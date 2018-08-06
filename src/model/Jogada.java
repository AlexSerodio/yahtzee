package model;

import java.util.ArrayList;

/**
 *
 * @author Alex Seródio Gonçalves
 */
public class Jogada {

    private int pontuacao;
    private TipoJogada tipoJogada;

    /**
     * construtor que seta o tipoJogada da jogada
     * @param tipoJogada o tipo da jogada a ser setado
     */
    public Jogada(TipoJogada tipoJogada) {
        setTipoJogada(tipoJogada);
    }
    
    /**
     * construtor que seta o tipoJogada da jogada e 
     * os dados que serão passados como parâmetro do método calcularJogada
     * @param tipoJogada o tipo da jogada a ser setado
     * @param dados o vetor de dados a ser passado no método calcularJogada()
     */
    public Jogada(TipoJogada tipoJogada, Dado[] dados) {
        setTipoJogada(tipoJogada);
        if(dados[0].getValor() != 0)
            calcularJogada(dados);
        else
            throw new RuntimeException("Role os dados primeiro.");
    }

    /**
     * @return a pontuacao
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * @param pontuacao a pontuacao a ser setada
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     * @return o tipo da jogada
     */
    public TipoJogada getTipoJogada() {
        return tipoJogada;
    }

    /**
     * @param tipoJogada o tipo da jogada a ser setado
     */
    public void setTipoJogada(TipoJogada tipoJogada) {
        this.tipoJogada = tipoJogada;
    }

    /**
     * separa os dados recebidos em 6 ArrayLists e a partir desses ArrayLists
     * verifica se os dados recebidos condizem com o tipo de jogada selecionada
     * se sim, calcula a pontuação da jogada, senão lança uma exceção
     * @param dados os dados do jogador a serem verificados
     */
    private void calcularJogada(Dado[] dados) {
        
        ArrayList<Dado> valorUm = new ArrayList<>();
        ArrayList<Dado> valorDois = new ArrayList<>();
        ArrayList<Dado> valorTres = new ArrayList<>();
        ArrayList<Dado> valorQuatro = new ArrayList<>();
        ArrayList<Dado> valorCinco = new ArrayList<>();
        ArrayList<Dado> valorSeis = new ArrayList<>();

        for(Dado dado : dados){
            switch(dado.getValor()){
                case 1: valorUm.add(dado);
                    break;
                case 2: valorDois.add(dado);
                    break;
                case 3: valorTres.add(dado);
                    break;
                case 4: valorQuatro.add(dado);
                    break;
                case 5: valorCinco.add(dado);
                    break;
                case 6: valorSeis.add(dado);
                    break;
            }
        }
        
       switch(getTipoJogada()){
            case JOGADA_DE_1: setPontuacao(valorUm.size() * 1);
                break;
            case JOGADA_DE_2: setPontuacao(valorDois.size() * 2);
                break;
            case JOGADA_DE_3: setPontuacao(valorTres.size() * 3);
                break;
            case JOGADA_DE_4: setPontuacao(valorQuatro.size() * 4);
                break;
            case JOGADA_DE_5: setPontuacao(valorCinco.size() * 5);
                break;
            case JOGADA_DE_6: setPontuacao(valorSeis.size() * 6);
                break;
            case TRINCA: 
                if((valorUm.size() >= 3) || (valorDois.size() >= 3) || (valorTres.size() >= 3) || 
                    (valorQuatro.size() >= 3) || (valorCinco.size() >= 3) || (valorSeis.size() >= 3)){
                    
                    int valor = 0;
                    for(Dado dado : dados){
                        valor += dado.getValor();
                    }
                    setPontuacao(valor);
                }else{
                    throw new RuntimeException("Os dados não são válidos para essa jogada.");
                }
                break;
            case QUADRA:
                if((valorUm.size() >= 4) || (valorDois.size() >= 4) || (valorTres.size() >= 4) || 
                    (valorQuatro.size() >= 4) || (valorCinco.size() >= 4) || (valorSeis.size() >= 4)){
                    
                    int valor = 0;
                    for(Dado dado : dados){
                        valor += dado.getValor();
                    }
                    setPontuacao(valor);
                }else{
                    throw new RuntimeException("Os dados não são válidos para essa jogada.");
                }
                break;
            case FULL_HOUSE:
                if((valorUm.size() == 3) || (valorDois.size() == 3) || (valorTres.size() == 3) || 
                    (valorQuatro.size() == 3) || (valorCinco.size() == 3) || (valorSeis.size() == 3)){
                    
                    if((valorUm.size() == 2) || (valorDois.size() == 2) || (valorTres.size() == 2) || 
                        (valorQuatro.size() == 2) || (valorCinco.size() == 2) || (valorSeis.size() == 2)){
                        
                        setPontuacao(25);
                        
                    }
                }else{
                    throw new RuntimeException("Os dados não são válidos para essa jogada.");
                }
                break;
            case SEQUENCIA_ALTA:
                if((valorUm.isEmpty()) && (valorDois.size() == 1) && (valorTres.size() == 1) && 
                    (valorQuatro.size() == 1) && (valorCinco.size() == 1) && (valorSeis.size() == 1)){
                    
                    setPontuacao(30);
                    
                }else{
                    throw new RuntimeException("Os dados não são válidos para essa jogada.");
                }
                break;
            case SEQUENCIA_BAIXA:
                if((valorUm.size() == 1) && (valorDois.size() == 1) && (valorTres.size() == 1) && 
                    (valorQuatro.size() == 1) && (valorCinco.size() == 1) && (valorSeis.isEmpty())){
                    
                    setPontuacao(40);
                    
                }else{
                    throw new RuntimeException("Os dados não são válidos para essa jogada.");
                }
                break;
            case GENERAL:
                if((valorUm.size() == 5) || (valorDois.size() == 5) || (valorTres.size() == 5) || 
                    (valorQuatro.size() == 5) || (valorCinco.size() == 5) || (valorSeis.size() == 5)){
                    
                    setPontuacao(50);
                    
                }else{
                    throw new RuntimeException("Os dados não são válidos para essa jogada.");
                }
                break;
            case JOGADA_ALEATORIA:
                int valor = 0;
                for(Dado dado : dados){
                    valor += dado.getValor();
                }
                setPontuacao(valor);
                break;
        }
    }
}