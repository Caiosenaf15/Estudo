// src/main/java/br/cefet/dao/TrajetoDao.java
package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Trajeto;

public class TrajetoDao {

    public void salvar(Trajeto trajeto) {
        String sql = "INSERT INTO trajetos (origem, destino, distancia, tempo_estimado) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trajeto.getPartida());
            stmt.setString(2, trajeto.getDestino());
            stmt.setDouble(3, trajeto.getDistancia());
            stmt.setInt(4, (int) trajeto.getGastoPorKm()); // Convertendo para tempo_estimado em minutos
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Trajeto trajeto) {
        String sql = "UPDATE trajetos SET origem = ?, destino = ?, distancia = ?, tempo_estimado = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trajeto.getPartida());
            stmt.setString(2, trajeto.getDestino());
            stmt.setDouble(3, trajeto.getDistancia());
            stmt.setInt(4, (int) trajeto.getGastoPorKm()); // Convertendo para tempo_estimado em minutos
            stmt.setInt(5, trajeto.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM trajetos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Trajeto buscarPorId(int id) {
        String sql = "SELECT id, origem, destino, distancia, tempo_estimado FROM trajetos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Trajeto t = new Trajeto();
                    t.setId(rs.getInt("id"));
                    t.setPartida(rs.getString("origem"));
                    t.setDestino(rs.getString("destino"));
                    t.setDistancia(rs.getDouble("distancia"));
                    t.setGastoPorKm(rs.getInt("tempo_estimado")); // Convertendo tempo_estimado para gastoPorKm
                    return t;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Trajeto> listarTodos() {
        List<Trajeto> lista = new ArrayList<>();
        String sql = "SELECT id, origem, destino, distancia, tempo_estimado FROM trajetos";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Trajeto t = new Trajeto();
                t.setId(rs.getInt("id"));
                t.setPartida(rs.getString("origem"));
                t.setDestino(rs.getString("destino"));
                t.setDistancia(rs.getDouble("distancia"));
                t.setGastoPorKm(rs.getInt("tempo_estimado")); // Convertendo tempo_estimado para gastoPorKm
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean possuiViagensAssociadas(int idTrajeto) {
        String sql = "SELECT COUNT(*) FROM viagens WHERE trajeto_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTrajeto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
