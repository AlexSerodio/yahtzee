package model;

import java.util.Random;

/**
 * 
 * @author Alex Seródio Gonçalves
 */
public class BandejaDeDados {
    
    private Dado[] dados = new Dado[5];
    
    public Dado[] getDados() {
        return dados;
    }
    
    /**
     * construtor que popula o vetor dados com 5 objetos dado
     */
    public BandejaDeDados(){
        Dado dado;
        for(int i = 0; i < getDados().length; i++){
            dado = new Dado();
            dado.setValor(0);
            dados[i] = dado;
        }
    }
    
    /**
     * gera valores aleatórios entre 1 e 6 para todos os objetos dado
     * do vetor dados
     */
    public void rolar(){
        Random random = new Random();
        for(Dado dado : getDados()){
            if(!dado.isManterDado())
                dado.setValor(random.nextInt(6) + 1);
        }
    }
}