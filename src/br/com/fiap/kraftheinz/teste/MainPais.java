package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.PaisDao;
import br.com.fiap.kraftheinz.dao.factory.DAOFactory;
import br.com.fiap.kraftheinz.model.Pais;

import java.util.ArrayList;
import java.util.List;

public class MainPais {
    public static void main(String[] args) {

       testaInsert();
       testaGetAll();
    }

    private static void testaInsert() {

        Pais pais1 = new Pais("Japão");
        Pais pais2 = new Pais("Canadá");
        Pais pais3 = new Pais("Índia");
        Pais pais4 = new Pais("Itália");

        List<Pais> listaPais = new ArrayList<>();
        listaPais.add(pais1);
        listaPais.add(pais2);
        listaPais.add(pais3);
        listaPais.add(pais4);

        PaisDao dao = DAOFactory.getDAOFactory(1).getPaisDao();


        for (Pais pais : listaPais){
            dao.insert(pais);
        }


    }
    private static void testaGetAll() {

        PaisDao dao = DAOFactory.getDAOFactory(1).getPaisDao();
        List<Pais> paisList = dao.getAll();

        for (Pais pais: paisList){
            System.out.println("País: " + pais.toString());
        }
    }
}
