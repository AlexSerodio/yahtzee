package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Alex Seródio Gonçalves
 */
public class JogadaTest {
    
    Dado[] dados = new Dado[5];
    
    public JogadaTest() {}
    
    @Before
    public void inicializaDados(){
        Dado dado = new Dado();
        for(int i = 0; i < dados.length; i++){
            dado = new Dado();
            dados[i] = dado;
        }
    }
    
    @Test
    public void test1JogadaDeUm() {                
        dados[0].setValor(1);
        dados[1].setValor(1);
        dados[2].setValor(1);
        dados[3].setValor(4);
        dados[4].setValor(5);
        Jogada jogada = new Jogada(TipoJogada.JOGADA_DE_1, dados);
        assertEquals(jogada.getPontuacao(), 3);
    }
    
    @Test
    public void test2Trinca() {                
        dados[0].setValor(4);
        dados[1].setValor(4);
        dados[2].setValor(4);
        dados[3].setValor(5);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.TRINCA, dados);
        assertEquals(jogada.getPontuacao(), 23);
    }
    
    @Test(expected=RuntimeException.class) 
    public void test3Trinca() {                
        dados[0].setValor(4);
        dados[1].setValor(4);
        dados[2].setValor(5);
        dados[3].setValor(5);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.TRINCA, dados);
    }
    
    @Test
    public void test4Quadra() {                
        dados[0].setValor(1);
        dados[1].setValor(5);
        dados[2].setValor(5);
        dados[3].setValor(5);
        dados[4].setValor(5);
        Jogada jogada = new Jogada(TipoJogada.QUADRA, dados);
        assertEquals(jogada.getPontuacao(), 21);
    }
    
    @Test(expected=RuntimeException.class) 
    public void test5Quadra() {                
        dados[0].setValor(1);
        dados[1].setValor(2);
        dados[2].setValor(5);
        dados[3].setValor(5);
        dados[4].setValor(5);
        Jogada jogada = new Jogada(TipoJogada.QUADRA, dados);
    }
    
    @Test
    public void test6FullHouse() {                
        dados[0].setValor(2);
        dados[1].setValor(2);
        dados[2].setValor(2);
        dados[3].setValor(6);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.FULL_HOUSE, dados);
        assertEquals(jogada.getPontuacao(), 25);
    }
    
    @Test(expected=RuntimeException.class) 
    public void test7FullHouse() {                
        dados[0].setValor(2);
        dados[1].setValor(2);
        dados[2].setValor(3);
        dados[3].setValor(6);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.FULL_HOUSE, dados);
    }
    
    @Test
    public void test8SequenciaAlta() {                
        dados[0].setValor(2);
        dados[1].setValor(3);
        dados[2].setValor(4);
        dados[3].setValor(5);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.SEQUENCIA_ALTA, dados);
        assertEquals(jogada.getPontuacao(), 30);
    }
    
    @Test(expected=RuntimeException.class) 
    public void test9SequenciaAlta() {                
        dados[0].setValor(2);
        dados[1].setValor(3);
        dados[2].setValor(1);
        dados[3].setValor(5);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.SEQUENCIA_ALTA, dados);
    }
    
    @Test
    public void test10SequenciaBaixa() {                
        dados[0].setValor(1);
        dados[1].setValor(2);
        dados[2].setValor(3);
        dados[3].setValor(4);
        dados[4].setValor(5);
        Jogada jogada = new Jogada(TipoJogada.SEQUENCIA_BAIXA, dados);
        assertEquals(jogada.getPontuacao(), 40);
    }
    
    @Test(expected=RuntimeException.class) 
    public void test11SequenciaBaixa() {                
        dados[0].setValor(1);
        dados[1].setValor(2);
        dados[2].setValor(3);
        dados[3].setValor(4);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.SEQUENCIA_BAIXA, dados);
    }
    
    @Test
    public void test12General() {                
        dados[0].setValor(4);
        dados[1].setValor(4);
        dados[2].setValor(4);
        dados[3].setValor(4);
        dados[4].setValor(4);
        Jogada jogada = new Jogada(TipoJogada.GENERAL, dados);
        assertEquals(jogada.getPontuacao(), 50);
    }
    
    @Test(expected=RuntimeException.class) 
    public void test13General() {                
        dados[0].setValor(4);
        dados[1].setValor(4);
        dados[2].setValor(4);
        dados[3].setValor(4);
        dados[4].setValor(3);
        Jogada jogada = new Jogada(TipoJogada.GENERAL, dados);
    }
    
    @Test
    public void test14General() {                
        dados[0].setValor(1);
        dados[1].setValor(4);
        dados[2].setValor(4);
        dados[3].setValor(5);
        dados[4].setValor(6);
        Jogada jogada = new Jogada(TipoJogada.JOGADA_ALEATORIA, dados);
        assertEquals(jogada.getPontuacao(), 20);
    }
}
