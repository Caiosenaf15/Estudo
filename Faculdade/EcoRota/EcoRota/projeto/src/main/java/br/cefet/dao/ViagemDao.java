// src/main/java/br/cefet/dao/ViagemDao.java
package br.cefet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Motorista;
import br.cefet.model.Trajeto;
import br.cefet.model.Viagem;

public class ViagemDao {

    public void salvar(Viagem viagem) {
        String sql = "INSERT INTO viagens (motorista_id, trajeto_id, data_viagem, hora_saida, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, viagem.getMotorista().getId());
            stmt.setInt(2, viagem.getTrajeto().getId());
            stmt.setDate(3, Date.valueOf(viagem.getData())); 
            stmt.setTime(4, Time.valueOf("08:00:00")); // Hora padrão de saída
            stmt.setString(5, "AGENDADA"); // Status padrão
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Viagem viagem) {
        String sql = "UPDATE viagens SET motorista_id = ?, trajeto_id = ?, data_viagem = ?, hora_saida = ?, status = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, viagem.getMotorista().getId());
            stmt.setInt(2, viagem.getTrajeto().getId());
            stmt.setDate(3, Date.valueOf(viagem.getData())); 
            stmt.setTime(4, Time.valueOf("08:00:00")); // Hora padrão de saída
            stmt.setString(5, "AGENDADA"); // Status padrão
            stmt.setInt(6, viagem.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM viagens WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Viagem buscarPorId(int id) {
        String sql = "SELECT v.id, v.motorista_id, v.trajeto_id, v.data_viagem, v.hora_saida, v.status, " +
                     "m.nome AS motorista_nome, m.idade AS motorista_idade, m.matricula AS motorista_matricula, " +
                     "t.origem AS trajeto_origem, t.destino AS trajeto_destino, t.distancia AS trajeto_distancia, t.tempo_estimado AS trajeto_tempo_estimado " +
                     "FROM viagens v " +
                     "JOIN motoristas m ON v.motorista_id = m.id " +
                     "JOIN trajetos t ON v.trajeto_id = t.id " +
                     "WHERE v.id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Motorista motorista = new Motorista();
                    motorista.setId(rs.getInt("motorista_id"));
                    motorista.setNome(rs.getString("motorista_nome"));
                    motorista.setIdade(rs.getInt("motorista_idade"));
                    motorista.setMatricula(rs.getString("motorista_matricula"));

                    Trajeto trajeto = new Trajeto();
                    trajeto.setId(rs.getInt("trajeto_id"));
                    trajeto.setPartida(rs.getString("trajeto_origem"));
                    trajeto.setDestino(rs.getString("trajeto_destino"));
                    trajeto.setDistancia(rs.getDouble("trajeto_distancia"));
                    trajeto.setGastoPorKm(rs.getInt("trajeto_tempo_estimado"));

                    
                    LocalDate data = null;
                    if (rs.getDate("data_viagem") != null) {
                        data = rs.getDate("data_viagem").toLocalDate();
                    }

                    Viagem v = new Viagem(
                        rs.getInt("id"),
                        motorista,
                        trajeto,
                        1, // passageiros padrão
                        data 
                    );
                    return v;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Viagem> listarTodos() {
        List<Viagem> lista = new ArrayList<>();
        String sql = "SELECT v.id, v.motorista_id, v.trajeto_id, v.data_viagem, v.hora_saida, v.status, " +
                     "m.nome AS motorista_nome, m.idade AS motorista_idade, m.matricula AS motorista_matricula, " +
                     "t.origem AS trajeto_origem, t.destino AS trajeto_destino, t.distancia AS trajeto_distancia, t.tempo_estimado AS trajeto_tempo_estimado " +
                     "FROM viagens v " +
                     "JOIN motoristas m ON v.motorista_id = m.id " +
                     "JOIN trajetos t ON v.trajeto_id = t.id";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Motorista motorista = new Motorista();
                motorista.setId(rs.getInt("motorista_id"));
                motorista.setNome(rs.getString("motorista_nome"));
                motorista.setIdade(rs.getInt("motorista_idade"));
                motorista.setMatricula(rs.getString("motorista_matricula"));

                Trajeto trajeto = new Trajeto();
                trajeto.setId(rs.getInt("trajeto_id"));
                trajeto.setPartida(rs.getString("trajeto_origem"));
                trajeto.setDestino(rs.getString("trajeto_destino"));
                trajeto.setDistancia(rs.getDouble("trajeto_distancia"));
                trajeto.setGastoPorKm(rs.getInt("trajeto_tempo_estimado"));

                
                LocalDate data = null;
                if (rs.getDate("data_viagem") != null) {
                    data = rs.getDate("data_viagem").toLocalDate();
                }

                Viagem v = new Viagem(
                    rs.getInt("id"),
                    motorista,
                    trajeto,
                    1, // passageiros padrão
                    data
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    


}