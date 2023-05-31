package br.com.fiap.kraftheinz.dao;

import br.com.fiap.kraftheinz.connection.ConnectionFactory;
import br.com.fiap.kraftheinz.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection connection;

    public ProdutoDao() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Produto produto) {
        String sql = "insert into T_KH_PRODUTO (cd_produto, nm_produto, cd_marca)" +
                "values (SQ_KH_PRODUTO.nextval, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getCdMarca());

            stmt.execute();
            stmt.close();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }

    public List<Produto> getAll() {

        List<Produto> produtos = new ArrayList<Produto>();
        String sql = "select * from T_KH_PRODUTO order by nm_produto ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("cd_produto"));
                produto.setNome(rs.getString("nm_produto"));

                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            return produtos;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Produto selectById(int numero) {
        Produto produto = null;
        String sql = "select * from T_KH_PRODUTO where cd_produto=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("nm_produto"));
                produto.setCodigo(rs.getInt("cd_produto"));

            }

            rs.close();
            stmt.close();
            return produto;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

}


