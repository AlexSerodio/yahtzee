package model;

/**
 *
 * @author Alex Seródio Gonçalves
 */
public class Dado {
    
    
    private int valor = 0;
    private boolean manterDado = false;

    /**
     * @return o valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor o valor a ser setado
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return o manterDado
     */
    public boolean isManterDado() {
        return manterDado;
    }

    /**
     * @param manterDado o manterDado a ser setado
     */
    public void setManterDado(boolean manterDado) {
        this.manterDado = manterDado;
    }
}