package br.com.cefet.modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import br.com.cefet.modelo.factory.ConnectionFactory;

public class TestaJDBCInsere {
    public static void main(String[] args) throws SQLException{
        String sql = "INSERT INTO contato(nome, email, endereco, data_nascimento) VALUES(?,?,?,?)";
        Connection conexao = new ConnectionFactory().getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
    }
}
