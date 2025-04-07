import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    PreparedStatement stmt = null;
    Connection conexao = null;
    String sql = "INSERT INTO produto(descricao, preco_de_custo) VALUES(?,?)";

    public ProdutoDao (Connection conexao) throws SQLException{
        this.conexao = conexao;
    }

    public void insert(Produto p){
        try {
            this.stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p.getDescricao());
            stmt.setDouble(2, p.getPreco_de_custo());

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o produto" + e.getMessage());
        }
    }

    public List<Produto> getALL() throws DaoException{
        List<Produto> produtos = new ArrayList<>();
        String listSql = "SELECT id, descricao, preco_de_custo FROM produto";
        try(Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(listSql)) {
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoDeCusto(rs.getDouble("preco_de_custo"));
                produtos.add(produto);
            }
        } catch(SQLException e){
            throw new DaoException("Erro ao recuperar produtos" + e.getMessage(), e);
        }
        return produtos;
    }
}

