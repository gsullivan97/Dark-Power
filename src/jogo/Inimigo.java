/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import jplay.Keyboard;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

/**
 *
 * @author Admin
 */
public class Inimigo extends Ator {
    
    private double ataque = 1;
    Sprite lutar;
    Keyboard keyboard;
    
    public Inimigo(int x, int y) {
        super(URL.sprite("zumbi.png"), 16, "Inimigo");
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
        this.velocidade = 0.3;
    }
    
    public void perseguir(double x, double y){
        if(this.x > x && this.y <= y + 50 && this.y >= y - 50){
            moveTo(x, y, velocidade);
            if(direcao != 1){
                setSequence(5, 8);
                direcao = 1;
            } movendo = true;
        }
        
        else if(this.x < x && this.y <= y + 50 && this.y >= - 50){
            moveTo(x, y, velocidade);
            if(direcao != 2){
                setSequence(9, 12);
                direcao = 2;
            } movendo = true;
        }
        
        else if(this.y > y){
            moveTo(x, y, velocidade);
            if(direcao != 4){
                setSequence(13, 16);
                direcao = 4;
            } movendo = true;
        }
        
        else if(this.y < y){
            moveTo(x, y, velocidade);
            if(direcao != 5){
                setSequence(1, 4);
                direcao = 5;
            } movendo = true;
        }
        
        if(movendo){
            update();
            movendo = false;
        }
    }

    void morrer() {
        if(this.energia <= 0){
            this.velocidade = 0;
            //this.ataque = 0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 1_000_000;
        }
    }
    
    Font f = new Font("arial", Font.BOLD, 20);
    
    public void atacar(Jogador jogador, Window janela){
        if(this.collided(jogador)){
            //Jogador.energia -= this.ataque;
            if(!Cenario1.luta)
                janela.drawText("Aperte enter para atacar", 300, 580, Color.WHITE, f);
            
            keyboard = janela.getKeyboard();
            if (keyboard.keyDown(Keyboard.ENTER_KEY) ){
                Cenario1.luta = true;
            }
            
        }else{
            Cenario1.luta = false;
        }
        
        if(Jogador.energia <= 0){
            System.exit(0);
        }
    }
    
}
