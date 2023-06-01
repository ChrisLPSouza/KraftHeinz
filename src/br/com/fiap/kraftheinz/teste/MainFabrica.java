package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.FabricaDao;
import br.com.fiap.kraftheinz.model.Fabrica;

import java.util.List;

public class MainFabrica {
    public static void main(String[] args) {

    	testaInsert();
        testaGetAll();
    }

    private static void testaInsert() {
       Fabrica fabrica = new Fabrica();
       fabrica.setNome("Goiás");
       fabrica.setCdPais(4);
       
       Fabrica fabrica2 = new Fabrica();
       fabrica2.setNome("Minas Gerais");
       fabrica2.setCdPais(4);


        FabricaDao dao = new FabricaDao();
        dao.insert(fabrica);
        dao.insert(fabrica2);

    }
    private static void testaGetAll() {

        FabricaDao dao = new FabricaDao();
        List<Fabrica> fabricas = dao.getAll();

        for (Fabrica fabrica: fabricas){
            System.out.println("Fábrica: " + fabrica.toString());
        }
    }
}
