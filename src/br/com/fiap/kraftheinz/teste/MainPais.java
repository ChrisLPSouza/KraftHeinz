package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.PaisDao;
import br.com.fiap.kraftheinz.model.Pais;

import java.util.ArrayList;
import java.util.List;

public class MainPais {
    public static void main(String[] args) {

       testaInsert();
       testaGetAll();
    }

    private static void testaInsert() {

        Pais pais1 = new Pais("França");
        Pais pais2 = new Pais("Itália");
        Pais pais3 = new Pais("Argentina");
        Pais pais4 = new Pais("Brasil");

        List<Pais> listaPais = new ArrayList<>();
        listaPais.add(pais1);
        listaPais.add(pais2);
        listaPais.add(pais3);
        listaPais.add(pais4);

        PaisDao dao = new PaisDao();


        for (Pais pais : listaPais){
            dao.insert(pais);
        }


    }
    private static void testaGetAll() {

        PaisDao dao = new PaisDao();
        List<Pais> paisList = dao.getAll();

        for (Pais pais: paisList){
            System.out.println("País: " + pais.toString());
        }
    }
}
