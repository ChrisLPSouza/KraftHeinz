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

        Produto produto = new Produto();
        produto.setNome("Ketchup");
        produto.setCdMarca(2);

        ProdutoDao dao = new ProdutoDao();
        dao.insert(produto);

    }
    private static void testaGetAll() {

        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.getAll();

        for (Produto produto: produtos){
            System.out.println("Produto: " + produto.toString());
        }


    }
}