package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Usuario;

public class UsuarioDao {
    public void salvar(Usuario usuario) {
        Connection conn = ConnectionFactory.getConnection();
        if (conn == null) {
            System.out.println("ERRO: Conexão com o banco de dados está nula!");
            throw new RuntimeException("Conexão com o banco de dados está nula!");
        }
        String sql = "INSERT INTO usuario (usuario, senha_hash, cor_fundo, cor_fonte) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenhaHash());
            stmt.setString(3, usuario.getCorFundo());
            stmt.setString(4, usuario.getCorFonte());
            stmt.executeUpdate();
            System.out.println("Usuário salvo com sucesso no banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Usuario buscarPorUsuario(String usuario) {
        Connection conn = ConnectionFactory.getConnection();
        if (conn == null) {
            System.out.println("ERRO: Conexão com o banco de dados está nula!");
            throw new RuntimeException("Conexão com o banco de dados está nula!");
        }
        String sql = "SELECT * FROM usuario WHERE usuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("usuario"),
                    rs.getString("senha_hash"),
                    rs.getString("cor_fundo"),
                    rs.getString("cor_fonte")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("usuario"),
                    rs.getString("senha_hash"),
                    rs.getString("cor_fundo"),
                    rs.getString("cor_fonte")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
} 