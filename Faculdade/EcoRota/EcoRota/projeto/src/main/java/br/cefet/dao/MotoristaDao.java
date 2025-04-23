// src/main/java/br/cefet/dao/MotoristaDao.java
package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Motorista;

public class MotoristaDao {

    public void salvar(Motorista motorista) {
        Connection conn = ConnectionFactory.getConnection();
        if (conn == null) {
            System.out.println("ERRO: Conexão com o banco de dados está nula! (MotoristaDao.salvar)");
            throw new RuntimeException("Conexão com o banco de dados está nula!");
        }
        String sql = "INSERT INTO motorista (nome, idade, matricula) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, motorista.getNome());
            stmt.setInt(2, motorista.getIdade());
            stmt.setString(3, motorista.getMatricula());
            stmt.executeUpdate();
            System.out.println("Motorista salvo com sucesso no banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Motorista motorista) {
        Connection conn = ConnectionFactory.getConnection();
        if (conn == null) {
            System.out.println("ERRO: Conexão com o banco de dados está nula! (MotoristaDao.atualizar)");
            throw new RuntimeException("Conexão com o banco de dados está nula!");
        }
        String sql = "UPDATE motorista SET nome = ?, idade = ?, matricula = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, motorista.getNome());
            stmt.setInt(2, motorista.getIdade());
            stmt.setString(3, motorista.getMatricula());
            stmt.setInt(4, motorista.getId());
            stmt.executeUpdate();
            System.out.println("Motorista atualizado com sucesso no banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        if (conn == null) {
            System.out.println("ERRO: Conexão com o banco de dados está nula! (MotoristaDao.excluir)");
            throw new RuntimeException("Conexão com o banco de dados está nula!");
        }
        String sql = "DELETE FROM motorista WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Motorista excluído com sucesso no banco de dados.");
        } catch (SQLException e) {
            throw e;
        }
    }

    public Motorista buscarPorId(int id) {
        Connection conn = ConnectionFactory.getConnection();
        if (conn == null) {
            System.out.println("ERRO: Conexão com o banco de dados está nula! (MotoristaDao.buscarPorId)");
            throw new RuntimeException("Conexão com o banco de dados está nula!");
        }
        String sql = "SELECT id, nome, idade, matricula FROM motorista WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Motorista m = new Motorista();
                    m.setId(rs.getInt("id"));
                    m.setNome(rs.getString("nome"));
                    m.setIdade(rs.getInt("idade"));
                    m.setMatricula(rs.getString("matricula"));
                    return m;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Motorista> listarTodos() {
        List<Motorista> lista = new ArrayList<>();
        Connection conn = ConnectionFactory.getConnection();
        if (conn == null) {
            System.out.println("ERRO: Conexão com o banco de dados está nula! (MotoristaDao.listarTodos)");
            throw new RuntimeException("Conexão com o banco de dados está nula!");
        }
        String sql = "SELECT id, nome, idade, matricula FROM motorista";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Motorista m = new Motorista();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setIdade(rs.getInt("idade"));
                m.setMatricula(rs.getString("matricula"));
                lista.add(m);
            }
            System.out.println("Listagem de motoristas realizada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
