package br.com.fiap.kraftheinz.dao;

import br.com.fiap.kraftheinz.connection.ConnectionFactory;
import br.com.fiap.kraftheinz.model.Lote;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LoteDao {
    private Connection connection;

    public LoteDao() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();

    }

    public void insert(Lote lote) {
        String sql = "insert into T_KH_LOTE (cd_lote, dt_fabricacao, dt_validade, qt_estoque, cd_produto, cd_embalagem, cd_fabrica)" +
                "values (?, ?, ?, ?, ?, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, lote.getCodigo());
            stmt.setDate(2, lote.getFabricacao());
            stmt.setDate(3, lote.getValidade());
            stmt.setInt(4, lote.getEstoque());
            stmt.setInt(5, lote.getCdProduto());
            stmt.setInt(6, lote.getCdEmbalagem());
            stmt.setInt(7, lote.getCdFabrica());

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
                lote.setCodigo(rs.getString("cd_lote"));
                lote.setFabricacao(rs.getDate("dt_fabricacao"));
                lote.setValidade(rs.getDate("dt_validade"));
                lote.setEstoque(rs.getInt("qt_estoque"));
                lote.setCdProduto(rs.getInt("cd_produto"));
                lote.setCdEmbalagem(rs.getInt("cd_embalagem"));
                lote.setCdFabrica(rs.getInt("cd_fabrica"));



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
                lote.setCodigo(rs.getString("cd_lote"));
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

}


