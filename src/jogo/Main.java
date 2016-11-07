/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;
import jplay.URL;
import jplay.Window;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Window janela = new Window(800, 600);
        GameImage plano = new GameImage("src/recursos/sprites/menu.png");
        Keyboard teclado = janela.getKeyboard();
        
        Sound musica = new Sound(URL.audio("fundo.mid"));
        musica.setRepeat(true);//faz a música se repetir continuamente.
        musica.setVolume(-0.2f * 100);
        musica.play();
        
        while(true){
            //plano.draw();
            janela.update();
            
            new Menu(janela);
            
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new EscolhePlayer(janela);
            }
        }
    }
    
}
