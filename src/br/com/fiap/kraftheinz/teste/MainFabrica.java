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
        // Random sequence = new Random();

        Fabrica fabrica = new Fabrica();
        // fabrica.setCodigo(sequence.nextInt(9999) + sequence.nextInt(9999));
       fabrica.setNome("Anápolis");
       fabrica.setCdPais(1);


        FabricaDao dao = new FabricaDao();
        dao.insert(fabrica);

    }


    private static void testaGetAll() {

        FabricaDao dao = new FabricaDao();
        List<Fabrica> fabricas = dao.getAll();

        for (Fabrica fabrica: fabricas){
            System.out.println("Fábrica: " + fabrica.toString());
        }


    }
}
