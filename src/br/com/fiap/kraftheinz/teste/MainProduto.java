package br.com.fiap.kraftheinz.teste;

import br.com.fiap.kraftheinz.dao.ProdutoDao;
import br.com.fiap.kraftheinz.model.Produto;
import java.util.List;

public class MainProduto {
    public static void main(String[] args) {

        testaInsert();
        testaGetAll();
    }
    private static void testaInsert() {

        Produto produto1 = new Produto();
        produto1.setNome("Ketchup");
        produto1.setCdMarca(1);
        
        Produto produto2 = new Produto();
        produto2.setNome("Molho de tomate");
        produto2.setCdMarca(2);

        ProdutoDao dao = new ProdutoDao();
        dao.insert(produto1);
        dao.insert(produto2);

    }
    private static void testaGetAll() {

        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.getAll();

        for (Produto produto: produtos){
            System.out.println("Produto: " + produto.toString());
        }


    }
}