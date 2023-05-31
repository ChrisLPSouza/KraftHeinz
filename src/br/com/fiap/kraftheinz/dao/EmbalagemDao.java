package br.com.fiap.kraftheinz.dao;

import br.com.fiap.kraftheinz.connection.ConnectionFactory;
import br.com.fiap.kraftheinz.model.Embalagem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmbalagemDao {
    private Connection connection;

    public EmbalagemDao() {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.conectar();
    }

    public void insert(Embalagem embalagem) {
        String sql = "insert into T_KH_EMBALAGEM (cd_embalagem, tp_embalagem, is_reciclavel, is_reutilizavel, is_compostavel)" +
                "values (SQ_KH_EMBALAGEM.nextval, ?, ?, ?, ?)" ;

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, embalagem.getTipo());
            stmt.setBoolean(2, embalagem.isReciclavel());
            stmt.setBoolean(3, embalagem.isReutilizavel());
            stmt.setBoolean(4, embalagem.isCompostavel());

            stmt.execute();
            stmt.close();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }


    }

    public List<Embalagem> getAll() {

        List<Embalagem> embalagens = new ArrayList<Embalagem>();
        String sql = "select * from T_KH_EMBALAGEM order by tp_embalagem ASC";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Embalagem embalagem = new Embalagem();
                embalagem.setCodigo(rs.getInt("cd_embalagem"));
                embalagem.setTipo(rs.getString("tp_embalagem"));
                embalagem.setReciclavel(rs.getBoolean("is_reciclavel"));
                embalagem.setReutilizavel(rs.getBoolean("is_reutilizavel"));
                embalagem.setCompostavel(rs.getBoolean("is_compostavel"));

                embalagens.add(embalagem);
            }
            rs.close();
            stmt.close();
            return embalagens;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    public Embalagem selectById(int numero) {
        Embalagem embalagem = null;
        String sql = "select * from T_KH_EMBALAGEM where cd_embalagem=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numero);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                embalagem = new Embalagem();
                embalagem.setTipo(rs.getString("tp_embalagem"));
                embalagem.setCodigo(rs.getInt("cd_embalagem"));

            }

            rs.close();
            stmt.close();
            return embalagem;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}

