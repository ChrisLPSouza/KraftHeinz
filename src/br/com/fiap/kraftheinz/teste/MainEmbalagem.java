package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.EmbalagemDao;
import br.com.fiap.kraftheinz.dao.factory.DAOFactory;
import br.com.fiap.kraftheinz.model.Embalagem;
import java.util.List;


public class MainEmbalagem {

    public static void main(String[] args) {

         testaInsert();
         testaGetAll();
    }

    private static void testaInsert() {

        Embalagem embalagem = new Embalagem();
        embalagem.setTipo("Plástico");
        embalagem.setReciclavel(true);
        embalagem.setReutilizavel(true);
        embalagem.setCompostavel(true);
        
        Embalagem embalagem2 = new Embalagem();
        embalagem2.setTipo("Alumínio");
        embalagem2.setReciclavel(true);
        embalagem2.setReutilizavel(true);
        embalagem2.setCompostavel(true);

        EmbalagemDao dao = DAOFactory.getDAOFactory(1).getEmbalagemDao();
        dao.insert(embalagem);
        dao.insert(embalagem2);


    }

    private static void testaGetAll() {

        EmbalagemDao dao = DAOFactory.getDAOFactory(1).getEmbalagemDao();
        List<Embalagem> embalagens = dao.getAll();

        for (Embalagem embalagem: embalagens){
            System.out.println("Embalagem: " + embalagem.toString());
        }
    }

}
