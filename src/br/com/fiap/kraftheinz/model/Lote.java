package br.com.fiap.kraftheinz.model;

import java.io.Serializable;
import java.sql.Date;

public class Lote implements Serializable {
    private int codigo;
    private Date fabricacao;
    private Date validade;
    private int estoque;
    private int cdProduto;
    private int cdEmbalagem;
    private int cdFabrica;

    public Lote(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(int cdProduto) {
        this.cdProduto = cdProduto;
    }

    public int getCdEmbalagem() {
        return cdEmbalagem;
    }

    public void setCdEmbalagem(int cdEmbalagem) {
        this.cdEmbalagem = cdEmbalagem;
    }

    public int getCdFabrica() {
        return cdFabrica;
    }

    public void setCdFabrica(int cdFabrica) {
        this.cdFabrica = cdFabrica;
    }

    public void altera(){

    }
    public void cadastra(){

    }
    public void cancela(){

    }

    @Override
    public String toString() {
        return "Lote{" +
                "codigo=" + codigo +
                ", fabricacao=" + fabricacao +
                ", validade=" + validade +
                ", estoque=" + estoque +
                ", cdProduto=" + cdProduto +
                ", cdEmbalagem=" + cdEmbalagem +
                ", cdFabrica=" + cdFabrica +
                '}';
    }
}
