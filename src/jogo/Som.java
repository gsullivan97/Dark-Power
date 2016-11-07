/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import jplay.Sound;
import jplay.URL;

/**
 *
 * @author Admin
 */
public class Som {
    
    private static Sound musica;
    
    public static void play(String audio){
        stop();
        musica = new Sound(URL.audio(audio));
        Som.musica.play();
        Som.musica.setVolume(-30f);
        Som.musica.setRepeat(true);
    }
    
    public static void stop(){
        if(Som.musica != null)
            musica.stop();
    }
    
}
