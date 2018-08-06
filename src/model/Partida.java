package model;

/**
 *
 * @author Alex Seródio Gonçalves
 */
public class Partida {

    private Jogador[] jogadores = new Jogador[4];
    private int vez = 0;
    
    /***
     * @return o vetor de jogadores
     */
    public Jogador[] getJogadores() {
        int quantidade = 0;
        for (Jogador jogador : jogadores) { 
            if (jogador != null) 
                quantidade++; 
        }
        
        Jogador[] resultado = new Jogador[quantidade];
        
        int i = 0; 
        for (Jogador jogador : jogadores) { 
            if (jogador != null) { 
                resultado[i] = jogador; 
                i++; 
            } 
        }
        return resultado;
    }
    
    /**
     * @return a vez do jogador
     */
    public int getVez() {
        return vez;
    }

    /**
     * @param vez a vez do jogador a ser setada
     */
    public void setVez(int vez) {
        this.vez = vez;
    }
    
    /**
     * 
     * @return o jogador que está na vez de jogar
     */
    public Jogador jogadorNaVez(){
        Jogador jogador = null;
        switch(getVez()){
            case 0: jogador = getJogadores()[0];
                break;
            case 1: jogador =  getJogadores()[1];
                break;
            case 2: jogador =  getJogadores()[2];
                break;
            case 3: jogador =  getJogadores()[3];
                break;
        }
        return jogador;
    }
    
    /**
     * avança a vez para o próximo jogador
     */
    public void proximoJogador(){
        if(getVez() < (getJogadores().length - 1))
            setVez(getVez() + 1);
        else
            setVez(0);
    }
    
    /**
     * Insere um novo jogador no vetor de jogadores
     * @param jogador o jogador a ser inserido no vetor
     */
    public void inserirJogador(Jogador jogador) {
        int i;
        for (i = 0; i < jogadores.length; i++) {
            if (jogadores[i] == null)
                break;
        }
        
        if (i == jogadores.length)
            throw new RuntimeException("Não pode ter mais de 4 jogadores.");
        
        jogadores[i] = jogador;
    }
    
    /**
     * percorre o vetor de jogadores, verificando a pontuação de cada jogador
     * @return o jogador com a maior pontuação
     */
    public Jogador obterJogadorMaiorPontuacao() {
        Jogador jogadorMaiorPontuacao = new Jogador("Temp");
        int maiorPontuacao = 0;
        for (Jogador jogador : getJogadores()) {
            int pontuacao = jogador.calcularPontuacaoJogador();
            if (pontuacao > maiorPontuacao) {
                maiorPontuacao = pontuacao;
                jogadorMaiorPontuacao = jogador;
            }
        }
        return jogadorMaiorPontuacao;
    }
    
    /**
     * Verifica se os jogadores não possuem mais jogadas restantes
     * @return true se as jogadas restantes de todos os jogadores forem 0 ou
     * false se algum jogador ainda tiver alguma jogada restante
     */
    public Boolean fimPartida(){
        
        int quantidade = 0;
        for(Jogador j : getJogadores()){
            if(j.getJogadasRestantes().length == 0)
                quantidade++;
        }
        return quantidade == getJogadores().length;
    }
}