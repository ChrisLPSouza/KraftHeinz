package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.MarcaDao;
import br.com.fiap.kraftheinz.model.Marca;
import java.util.ArrayList;
import java.util.List;

public class MainMarca {

    public static void main(String[] args) {

        testaInsert();
        testaGetAll();
    }
    private static void testaInsert() {

        Marca marca1 = new Marca("Heinz");
        Marca marca2 = new Marca("Quero");
        Marca marca3 = new Marca("Kraft");

        List<Marca> listaMarca = new ArrayList<>();
        listaMarca.add(marca1);
        listaMarca.add(marca2);
        listaMarca.add(marca3);

        MarcaDao dao = new MarcaDao();

        for (Marca marca : listaMarca){
           dao.insert(marca);
        }

    }
    private static void testaGetAll() {

        MarcaDao dao = new MarcaDao();
        List<Marca> marcas = dao.getAll();

        for (Marca marca: marcas){
            System.out.println("Marca: " + marca.toString());
        }
    }
}
