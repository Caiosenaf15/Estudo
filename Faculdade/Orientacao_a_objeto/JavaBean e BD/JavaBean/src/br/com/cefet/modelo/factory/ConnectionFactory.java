package br.com.cefet.modelo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConexao(){
        try{
            System.out.println("Conectando com o banco...");
            return DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
