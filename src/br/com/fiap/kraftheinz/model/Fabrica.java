package br.com.fiap.kraftheinz.model;

import java.io.Serializable;

public class Fabrica implements Serializable {
    private int codigo;
    private String nome;
    private int cdPais;

    public Fabrica(){

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

    public int getCdPais() {
        return cdPais;
    }

    public void setCdPais(int cdPais) {
        this.cdPais = cdPais;
    }

    public void altera(){

    }
    public void cadastra(){

    }
    public void cancela(){

    }

    @Override
    public String toString() {
        return "Fabrica{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cdPais=" + cdPais +
                '}';
    }
}
