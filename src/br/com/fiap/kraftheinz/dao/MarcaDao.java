package br.com.fiap.kraftheinz.dao;

import br.com.fiap.kraftheinz.connection.ConnectionFactory;
import br.com.fiap.kraftheinz.model.Marca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcaDao {
    private Connection connection;

    public MarcaDao() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Marca marca) {
        String sql = "insert into T_KH_MARCA (cd_marca, nm_marca)" +
                "values (SQ_KH_MARCA.nextval, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, marca.getNome());

            stmt.execute();
            stmt.close();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }

    public List<Marca> getAll() {

        List<Marca> marcas = new ArrayList<Marca>();
        String sql = "select * from T_KH_MARCA order by cd_marca ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Marca marca = new Marca();
                marca.setCodigo(rs.getInt("cd_marca"));
                marca.setNome(rs.getString("nm_marca"));

                marcas.add(marca);
            }
            rs.close();
            stmt.close();
            return marcas;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Marca selectById(int numero) {
        Marca marca = null;
        String sql = "select * from T_KH_MARCA where cd_marca=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                marca = new Marca();
                marca.setCodigo(rs.getInt("cd_marca"));
                marca.setNome(rs.getString("nm_marca"));

            }

            rs.close();
            stmt.close();
            return marca;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    }



