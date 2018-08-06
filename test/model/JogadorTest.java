package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Alex Seródio Gonçalves
 */
public class JogadorTest {
    
    Jogador jogador;
    
    public JogadorTest() {
    }

    @Before
    public void criaJogador() {
        jogador = new Jogador("Teste");
    }
    
    @Test(expected=RuntimeException.class) 
    public void test1ManterDado() {
        jogador.manterDado(jogador.getBandejaDeDados().getDados()[1]);
    }
    
    @Test(expected=RuntimeException.class) 
    public void test2ArremessarDados() {
        jogador.setRolagensRestantes(0);
        jogador.arremessarDados();
    }
    
    @Test 
    public void test3RealizarJogada() {
        jogador.arremessarDados();
        Jogada jogada = new Jogada(TipoJogada.JOGADA_ALEATORIA, jogador.getBandejaDeDados().getDados());
        jogador.realizarJogada(jogada);
        
        assertEquals(1, jogador.getJogadasRealizadas().length);
    }
}
