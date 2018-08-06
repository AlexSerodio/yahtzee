package model;

import java.util.ArrayList;

/**
 *
 * @author Alex Seródio Gonçalves
 */
public class Jogador {
    
    private String nome;
    private int rolagensRestantes = 3;
    private boolean descartarJogada = false;
    private BandejaDeDados bandejaDeDados = new BandejaDeDados();
    private ArrayList<Jogada> jogadasRealizadas = new ArrayList<>();
    private ArrayList<Jogada> jogadasRestantes = new ArrayList<>();
    
    /**
     * Construtor que recebe o nome do jogador a ser instanciado
     * e popula o jogadasRestantes com todas as jogadas possíveis
     * @param nome do jogador
     */
    public Jogador(String nome){
        setNome(nome);
        Jogada jogada;
        jogada = new Jogada(TipoJogada.JOGADA_DE_1);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.JOGADA_DE_2);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.JOGADA_DE_3);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.JOGADA_DE_4);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.JOGADA_DE_5);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.JOGADA_DE_6);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.TRINCA);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.QUADRA);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.FULL_HOUSE);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.SEQUENCIA_ALTA);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.SEQUENCIA_BAIXA);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.GENERAL);
        jogadasRestantes.add(jogada);
        jogada = new Jogada(TipoJogada.JOGADA_ALEATORIA);
        jogadasRestantes.add(jogada);
    }
    
    /**
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome o nome a ser setado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return a quantidade de rolagens restantes
     */
    public int getRolagensRestantes() {
        return rolagensRestantes;
    }

    /**
     * @param rolagensRestantes a quantidade de rolagens restantes a ser setada
     */
    public void setRolagensRestantes(int rolagensRestantes) {
        this.rolagensRestantes = rolagensRestantes;
    }
    
    /**
     * @return the descartarJogada
     */
    public boolean isDescartarJogada() {
        return descartarJogada;
    }

    /**
     * @param descartarJogada the descartarJogada to set
     */
    public void setDescartarJogada(boolean descartarJogada) {
        this.descartarJogada = descartarJogada;
    }
    
    /**
     * @return a bandejaDeDados
     */
    public BandejaDeDados getBandejaDeDados() {
        return bandejaDeDados;
    }
    
    /***
     * @return o vetor de jogadas realizadas
     */
    public Jogada[] getJogadasRealizadas(){
        Jogada[] resultado = new Jogada[jogadasRealizadas.size()];
        jogadasRealizadas.toArray(resultado);
        return resultado;
    }
    
    /***
     * @return o vetor de jogadas restantes 
     */
    public Jogada[] getJogadasRestantes(){
        Jogada[] resultado = new Jogada[jogadasRestantes.size()];
        jogadasRestantes.toArray(resultado);
        return resultado;
    }
    
    /**
     * Altera o valor da variável manterDado de false para true. 
     * Ao fazer isso o método rolar() da classe bandejaDeDados não 
     * pode mais rolar esse dado
     * @param dado o dado cuja a variável manterDado será alterada
     */
    public void manterDado(Dado dado) {
        if(getBandejaDeDados().getDados()[0].getValor() != 0){
            for(Dado d : getBandejaDeDados().getDados()){
                if(d.equals(dado))
                    d.setManterDado(true);
            }
        }else{
            throw new RuntimeException("Role os dados primeiro.");
        }
    }

    /**
     * Chama o método rolar() da classe BandejaDeDados se o jogador tiver
     * rolagens restantes
     */
    public void arremessarDados(){
        if(getRolagensRestantes() > 0){
            getBandejaDeDados().rolar();
            setRolagensRestantes(getRolagensRestantes() - 1);
        }else{
            throw new RuntimeException("Não há mais rolagens restantes.");
        }
    }
    
    /**
     * Salva a jogada no ArrayList jogadasRealizadas e remove a mesma jogada 
     * do ArrayList jogadasRestantes
     * @param jogada jogada a ser adicionada e removida dos ArrayLists
     */
    public void realizarJogada(Jogada jogada) {
        jogadasRealizadas.add(jogada);
        for(Jogada j : jogadasRestantes){
            if(j.getTipoJogada().equals(jogada.getTipoJogada())){
                jogadasRestantes.remove(j);
                break;
            }
        }  
    }

    /**
     * Verifica se o jogador ainda pode fazer alguma jogada.
     * Se não puder, seta a variável descartarJogada como true
     */
    public void verificarJogadasPossiveis(){
        if(getRolagensRestantes() == 0){
            int i = 0;
            Jogada jogadaTeste;
            for(Jogada jogada : getJogadasRestantes()){
                try{
                    jogadaTeste = new Jogada(jogada.getTipoJogada(), getBandejaDeDados().getDados());
                    break;
                }catch(RuntimeException e){
                    i++;
                }
            }
            if(getJogadasRestantes().length == i){
                setDescartarJogada(true);
                throw new RuntimeException("Não há mais possibilidades de jogadas.");
            }
        }
    }
    
    /**
     * Percorre o ArrayList jogadasRealizadas e soma o valor de cada jogada,
     * resultando na pontuação total do jogador
     * @return a pontuação total do jogador
     */
    public int calcularPontuacaoJogador() {
        int pontuacao = 0;
        for(Jogada jogada : jogadasRealizadas){
            pontuacao += jogada.getPontuacao();
        }
        
        return pontuacao;
    }
}