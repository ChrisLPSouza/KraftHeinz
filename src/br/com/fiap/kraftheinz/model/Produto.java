package br.com.fiap.kraftheinz.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private int codigo;
    private String nome;
    private int cdMarca;

    public Produto () {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCdMarca() {
        return cdMarca;
    }

    public void setCdMarca(int cdMarca) {
        this.cdMarca = cdMarca;
    }

    public void altera() {

    }
    public void cadastra() {

    }
    public void cancela() {

    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cdMarca=" + cdMarca +
                '}';
    }
}