package br.com.fiap.kraftheinz.dao;

import br.com.fiap.kraftheinz.connection.ConnectionFactory;
import br.com.fiap.kraftheinz.model.Embalagem;
import br.com.fiap.kraftheinz.model.Fabrica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FabricaDao {
    private Connection connection;

    public void FabricaDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Fabrica fabrica) {
        String sql = "insert into T_KH_FABRICA (cd_fabrica, nm_fabrica, cd_pais)" +
                "values (SQ_FABRICA.nextval, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, fabrica.getNome());
            stmt.setInt(2, fabrica.getCdPais());

            stmt.execute();
            stmt.close();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }

    public List<Fabrica> getAll() {

        List<Fabrica> fabricas = new ArrayList<Fabrica>();
        String sql = "select * from T_KH_FABRICA order by nm_fabrica ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Fabrica fabrica = new Fabrica();
                fabrica.setCodigo(rs.getInt("cd_fabrica"));
                fabrica.setNome(rs.getString("nm_fabrica"));

                fabricas.add(fabrica);
            }
            rs.close();
            stmt.close();
            return fabricas;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Fabrica selectById(int numero) {
        Fabrica fabrica = null;
        String sql = "select * from T_KH_FABRICA where cd_fabrica=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                fabrica = new Fabrica();
                fabrica.setNome(rs.getString("nm_fabrica"));
                fabrica.setCodigo(rs.getInt("cd_fabrica"));

            }

            rs.close();
            stmt.close();
            return fabrica;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
//    public void delete(int numero)  {
//        String sql = "delete from T_KH_FABRICA where cd_fabrica=?";
//        try{
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, numero);
//            stmt.execute();
//            stmt.close();
//            System.out.println("Deletado com sucesso!");
//        }catch (SQLException e){
//            System.err.println("Erro: " + e.getMessage());
//        }
//
//    }
//    public void update(Fabrica fabrica) {
//        String sql = "update T_KH_FABRICA set nm_fabrica=? where cd_fabrica=?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//
//            stmt.setString(1, fabrica.getNome());
//            stmt.setInt(2, fabrica.getCodigo());
//
//            stmt.execute();
//            stmt.close();
//            System.out.println("Atualizado com sucesso!");
//        } catch (SQLException e){
//            System.err.println("Erro: " + e.getMessage());
//        }
//
//
//    }
}


