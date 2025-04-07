import java.sql.Connection;

public class BDSingleton {
    private Connection conexao = null;
    private static BDSingleton instancia = null;
    //Construtor Privado
    private BDSingleton(){
        
    }

    public static synchronized BDSingleton getInstancia(){
        return BDSingleton.instancia;
    }

    public Connection getConexao(){
        return this.conexao;
    }
}
