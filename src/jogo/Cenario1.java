/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import javax.swing.JOptionPane;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

/**
 *
 * @author Admin
 */
public class Cenario1 {
    
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    private Inimigo inimigo;

    public Cenario1(Window janela, String nome) {
        this.janela = janela;
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario1.scn");
        
        jogador = new Jogador(640, 350, nome);
        teclado = janela.getKeyboard();
        inimigo = new Inimigo(300, 300);
        
        //Som.play("fundo.mid");
        run();
    }
    
    private void run(){
        while(true){
            //cena.draw();
            
            jogador.mover(janela, teclado);
            jogador.caminho(cena);
            inimigo.caminho(cena);
            inimigo.perseguir(jogador.x, jogador.y);
            
            cena.moveScene(jogador);
            
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            
            jogador.atirar(janela, cena, teclado, inimigo);
            inimigo.morrer();
            
            inimigo.atacar(jogador);
            
            jogador.energia(janela);
            
            inimigo.x += cena.getXOffset();
            inimigo.y += cena.getYOffset();
            
            jogador.draw();
            inimigo.draw();
            janela.delay(2); 
            janela.update();
        }
    }
    
    
}
