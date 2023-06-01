package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.LoteDao;
import br.com.fiap.kraftheinz.model.Lote;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MainLote {
    public static void main(String[] args) {

        testaInsert();
        testaGetAll();

    }
    private static void testaInsert() {
        // Random sequence = new Random();

        Lote lote = new Lote();
        lote.setCodigo("L311311TS1NG");
        lote.setFabricacao(new Date(System.currentTimeMillis()));
        lote.setValidade(new Date(newDate ("05-10-2024")));
        lote.setEstoque(582);
        lote.setCdProduto(1);
        lote.setCdEmbalagem(1);
        lote.setCdFabrica(2);



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
    private static long newDate (String date) {
        // String string_date = "12-December-2012";

        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        try {
            java.util.Date d = f.parse(date);
            long milliseconds = d.getTime();
            return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
