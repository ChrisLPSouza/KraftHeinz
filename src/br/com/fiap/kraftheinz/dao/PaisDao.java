package br.com.fiap.kraftheinz.dao;

import br.com.fiap.kraftheinz.connection.ConnectionFactory;
import br.com.fiap.kraftheinz.model.Pais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisDao {
    private Connection connection;

    public PaisDao() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Pais pais) {
        String sql = "insert into T_KH_PAIS (cd_pais, nm_pais)" +
                "values (SQ_KH_PAIS.nextval, ?)";

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, pais.getNome());

            stmt.execute();
            stmt.close();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }

    public List<Pais> getAll() {

        List<Pais> paisList = new ArrayList<Pais>();
        String sql = "select * from T_KH_PAIS order by cd_pais ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setCodigo(rs.getInt("cd_pais"));
                pais.setNome(rs.getString("nm_pais"));

                paisList.add(pais);
            }
            rs.close();
            stmt.close();
            return paisList;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Pais selectById(int numero) {
        Pais pais = null;
        String sql = "select * from T_KH_PAIS where cd_pais=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                pais = new Pais();
                pais.setCodigo(rs.getInt("cd_pais"));
                pais.setNome(rs.getString("nm_pais"));

            }

            rs.close();
            stmt.close();
            return pais;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}