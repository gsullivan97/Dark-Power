/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogo;

import javax.swing.JOptionPane;
import jplay.Keyboard;
import jplay.Sound;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

 /**
  * @author Gefersom Cardoso Lima
  * Federal Fluminense University - UFF - Brazil
  * Computer Science
  */

public class Menu
{
        Window window;
        Sprite backGround;
        Keyboard keyboard;
        int opcaoEscolhida = 0;
        Sound musica;

        public Menu(Window janela)
        {
                carregarObjetos(janela);
                loop();
                descarregarObjetos();
        }

        private void carregarObjetos(Window janela)
        {
                //Cria uma janela com dimensão de 800 x 600.
                this.window = janela;

                //Carrega o sprite a ser usado, o valor 3 corresponde ao número de frames usados.
                backGround = new Sprite(URL.sprite("menu.png"), 2);

                //Captura uma instância de teclado presetente pela janela que criamos.
                keyboard = window.getKeyboard();

                //Como as teclas padrões do teclado, up, down, left, right
                //são adiconadas com o comportamento Keyboard.DETECT_EVERY_PRESS,
                //mudamos o coportamento para DETECT_INITIAL_PRESS_ONLY. Para entender
                //o que aconteceria sem não fizessemos isso, apague os comandos abaixo e
                //execute o jogo:
                keyboard.setBehavior(Keyboard.UP_KEY,   Keyboard.DETECT_INITIAL_PRESS_ONLY);
                keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        }
        
        private void desenhar()
        {
                //Desenha a imagem usada como fundo da tela.
                backGround.draw();

                //Mostra as atualizações - esse método não pode faltar e tem 
                //que ser o último a ser chamado.
                window.display();        
        }
        
        //Escolha de opções do menu...
        private void verificarOpcaoEscolhida()
        {                

                boolean escolheuUmaOpcao = true;

                //Se a tecla foi pressionada...
                if ( keyboard.keyDown(Keyboard.UP_KEY) )
                {
                        //O if serve para não deixar que a opção seja menor que zero.
                        if (opcaoEscolhida > 0)                        
                            opcaoEscolhida--;                        
                }
                else
                {
                        //Se a tecla para baixo foi pressionada...
                        if ( keyboard.keyDown(Keyboard.DOWN_KEY) )
                        {
                            //O if serve para não deixar que a opção seja maior que dois.
                            if (opcaoEscolhida < 2)                            
                                opcaoEscolhida++;                            
                        }
                        else
                        {
                            escolheuUmaOpcao = false;
                        }
                }

                if (escolheuUmaOpcao)
                {
                    Sound option = new Sound(URL.audio("som.wav"));
                    playSom(option);
                }

                //Seta a opção do menu escolhida pelo usuário.
                backGround.setCurrFrame(opcaoEscolhida);
                
                if (keyboard.keyDown(Keyboard.ENTER_KEY)){
                    keyboard.setBehavior(Keyboard.UP_KEY,   Keyboard.DETECT_EVERY_PRESS);
                    keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
                    switch(opcaoEscolhida){
                        case 0:
                            new EscolhePlayer(window);
                        case 1:
                            System.exit(0);
                    }
                }
        }
        
        private void descarregarObjetos()
        {                        
                window.exit();
                window = null;
                backGround = null;
                keyboard = null;
        }


        private void loop()
        {
                boolean sair = false;
                do
                {
                        desenhar();
                        verificarOpcaoEscolhida();

                        //Se apertar a tecla ESC, sai da tela inicial.
                        if (keyboard.keyDown(Keyboard.ESCAPE_KEY))
                            sair = true;
                        
                }while(sair == false);
        }
        
        public void playSom(Sound som){
            som.setVolume(-0.2f * 100);
            som.play();
        }
}