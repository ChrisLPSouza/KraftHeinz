package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.EmbalagemDao;
import br.com.fiap.kraftheinz.model.Embalagem;
import java.util.List;


public class MainEmbalagem {

    public static void main(String[] args) {

         testaInsert();
         testaGetAll();
    }

    private static void testaInsert() {

        Embalagem embalagem = new Embalagem();
        embalagem.setTipo("Vidro");
        embalagem.setReciclavel(true);
        embalagem.setReutilizavel(true);
        embalagem.setCompostavel(false);
        
        Embalagem embalagem2 = new Embalagem();
        embalagem2.setTipo("Plástico");
        embalagem2.setReciclavel(true);
        embalagem2.setReutilizavel(false);
        embalagem2.setCompostavel(false);

        EmbalagemDao dao = new EmbalagemDao();
        dao.insert(embalagem);
        dao.insert(embalagem2);


    }

    private static void testaGetAll() {

        EmbalagemDao dao = new EmbalagemDao();
        List<Embalagem> embalagens = dao.getAll();

        for (Embalagem embalagem: embalagens){
            System.out.println("Embalagem: " + embalagem.toString());
        }
    }

}
