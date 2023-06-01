package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.FabricaDao;
import br.com.fiap.kraftheinz.dao.factory.DAOFactory;
import br.com.fiap.kraftheinz.model.Fabrica;

import java.util.List;

public class MainFabrica {
    public static void main(String[] args) {

    	testaInsert();
        testaGetAll();
    }

    private static void testaInsert() {
       Fabrica fabrica = new Fabrica();
       fabrica.setNome("Amsterdã");
       fabrica.setCdPais(14);
       
       Fabrica fabrica2 = new Fabrica();
       fabrica2.setNome("Santa Catarina");
       fabrica2.setCdPais(15);


        FabricaDao dao = DAOFactory.getDAOFactory(1).getFabricaDao();
        dao.insert(fabrica);
        dao.insert(fabrica2);

    }
    private static void testaGetAll() {

        FabricaDao dao = DAOFactory.getDAOFactory(1).getFabricaDao();
        List<Fabrica> fabricas = dao.getAll();

        for (Fabrica fabrica: fabricas){
            System.out.println("Fábrica: " + fabrica.toString());
        }
    }
}
