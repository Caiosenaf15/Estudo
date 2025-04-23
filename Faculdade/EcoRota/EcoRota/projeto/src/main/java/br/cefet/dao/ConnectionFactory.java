package br.cefet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Credenciais do banco de dados (idealmente, deveriam vir de um arquivo de configuração externo)
    private static final String URL = "jdbc:mysql://localhost:3306/ecorota";
    private static final String USER = "root"; // Altere para o seu usuário do MySQL
    private static final String PASSWORD = "2543"; // Altere para a sua senha do MySQL

    public static Connection getConnection() {
        try {
            // Carrega o driver JDBC do MySQL (para versões mais recentes, pode ser omitido,
            // mas é boa prática para garantir)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC do MySQL não encontrado.");
            e.printStackTrace();
            return null;
        }

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
            // Em um ambiente de produção, você pode relançar uma exceção personalizada
            // ou logar o erro de forma mais robusta.
            return null;
        }
    }
}