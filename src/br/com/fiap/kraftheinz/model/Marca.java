package br.com.fiap.kraftheinz.model;

import java.io.Serializable;

public class Marca implements Serializable {
    private int codigo;
    private String nome;

    public Marca(){

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
    public void altera(){

    }
    public void cadastra(){

    }
    public void cancela(){

    }

    @Override
    public String toString() {
        return "Marca{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }
}