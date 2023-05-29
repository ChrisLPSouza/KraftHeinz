package br.com.fiap.kraftheinz.dao;

import br.com.fiap.kraftheinz.connection.ConnectionFactory;
import br.com.fiap.kraftheinz.model.Fabrica;
import br.com.fiap.kraftheinz.model.Lote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoteDao {
    private Connection connection;

    public void LoteDAO() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Lote lote) {
        String sql = "insert into T_KH_LOTE (cd_lote, dt_fabricacao, dt_validade, qt_estoque, cd_produto, cd_embalagem, cd_fabrica)" +
                "values (SQ_KH_LOTE.nextval, ?, ?, ?, ?, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setDate(1, lote.getFabricacao());
            stmt.setDate(2, lote.getValidade());
            stmt.setInt(3, lote.getEstoque());
            stmt.setInt(4, lote.getCdProduto());
            stmt.setInt(5, lote.getCdEmbalagem());
            stmt.setInt(6, lote.getCdFabrica());

            stmt.execute();
            stmt.close();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }

    public List<Lote> getAll() {

        List<Lote> lotes = new ArrayList<Lote>();
        String sql = "select * from T_KH_LOTE order by cd_lote ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Lote lote = new Lote();
                lote.setCodigo(rs.getInt("cd_lote"));
                lote.setEstoque(rs.getInt("qt_estoque"));

                lotes.add(lote);
            }
            rs.close();
            stmt.close();
            return lotes;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Lote selectById(int numero) {
        Lote lote = null;
        String sql = "select * from T_KH_LOTE where cd_lote=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lote = new Lote();
                lote.setCodigo(rs.getInt("cd_lote"));
                lote.setEstoque(rs.getInt("qt_estoque"));

            }

            rs.close();
            stmt.close();
            return lote;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
//    public void delete(int numero)  {
//        String sql = "delete from T_KH_LOTE where cd_lote=?";
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
//    public void update(Lote lote) {
//        String sql = "update T_KH_LOTE set qt_estoque=? where cd_lote=?";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//
//            stmt.setInt(1, lote.getCodigo());
//            stmt.setInt(2, lote.getEstoque());
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


