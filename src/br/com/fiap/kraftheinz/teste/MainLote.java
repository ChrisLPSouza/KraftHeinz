package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.FabricaDao;
import br.com.fiap.kraftheinz.dao.LoteDao;
import br.com.fiap.kraftheinz.model.Fabrica;
import br.com.fiap.kraftheinz.model.Lote;

import java.sql.Date;
import java.util.List;

public class MainLote {
    public static void main(String[] args) {

        testaInsert();
        //testaGetAll();


    }

    private static void testaInsert() {
        // Random sequence = new Random();

        Lote lote = new Lote();
        // lote.setCodigo(sequence.nextInt(9999) + sequence.nextInt(9999));
        lote.setFabricacao(new Date(System.currentTimeMillis()));
        lote.setEstoque(5800);
        lote.setCdEmbalagem(1);
        lote.setCdFabrica(1);
        lote.setCdProduto(1);


        LoteDao dao = new LoteDao();
        dao.insert(lote);

    }


    private static void testaGetAll() {

        LoteDao dao = new LoteDao();
        List<Lote> lotes = dao.getAll();

        for (Lote lote: lotes){
            System.out.println("Lote: " + lote.toString());
        }


    }
}
