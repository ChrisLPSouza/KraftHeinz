package br.com.fiap.kraftheinz.model;

import java.io.Serializable;

public class Embalagem implements Serializable {

    private int codigo;
    private String tipo;
    private boolean reciclavel;
    private boolean reutilizavel;
    private  boolean compostavel;

    public Embalagem(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isReciclavel() {
        return reciclavel;
    }

    public void setReciclavel(boolean reciclavel) {
        this.reciclavel = reciclavel;
    }

    public boolean isReutilizavel() {
        return reutilizavel;
    }

    public void setReutilizavel(boolean reutilizavel) {
        this.reutilizavel = reutilizavel;
    }

    public boolean isCompostavel() {
        return compostavel;
    }

    public void setCompostavel(boolean compostavel) {
        this.compostavel = compostavel;
    }
    public void altera(){

    }
    public void cadastra(){

    }
    public void cancela(){

    }

    @Override
    public String toString() {
        return "Embalagem{" +
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                ", reciclavel=" + reciclavel +
                ", reutilizavel=" + reutilizavel +
                ", compostavel=" + compostavel +
                '}';
    }
}
