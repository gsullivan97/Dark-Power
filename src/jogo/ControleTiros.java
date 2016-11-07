/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Vector;
import jplay.Scene;
import jplay.Sound;
import jplay.TileInfo;
import jplay.URL;

/**
 *
 * @author Admin
 */
public class ControleTiros {
    
    LinkedList<Tiro> tiros = new LinkedList<>();
    
    public void adicionaTiro(double x, double y, int caminho, Scene cena){
        Tiro tiro = new Tiro(x, y, caminho);
        tiros.add(tiro);
        cena.addOverlay(tiro);
        somDisparo();
    }
    
    public void run(Ator inimigo){
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);
            
            if(tiro.collided(inimigo)){
                tiro.x = 10000;
                inimigo.energia -= 250;
            }
        }
    }
    
    private void somDisparo(){
        //new Sound(URL.audio("flecha.wav")).play();
    }
    
    
}
