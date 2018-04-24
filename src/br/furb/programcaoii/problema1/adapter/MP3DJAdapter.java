package br.furb.programcaoii.problema1.adapter;

import br.furb.programcaoii.problema1.target.FormatoAudio;
import java.util.logging.Level;
import java.util.logging.Logger;
import problema1.MP3DJ;
/**
 *
 * @author silvinos
 */
public class MP3DJAdapter implements FormatoAudio {

    //Atributos da classe    
    private int tempoAudio;
    private MP3DJ mp3DJ;
    @Override
    public void abrir(String caminho) {
        mp3DJ = new MP3DJ();
        //passo o caminho para o metodo setFile para setar o arquivo  
        mp3DJ.setFile(caminho);
    }

    @Override
    public void reproduzir() {        
        mp3DJ.play();
    }

    @Override
    public void pausar() {
        //paro a reprodução
        mp3DJ.stop();
        //passo para o atributo tempoAudio o valor da posição em que está
        tempoAudio = mp3DJ.forward(0);
    }

    @Override
    public void parar() {
        //retrocedo o tempo da reprodução para o inicio.
        mp3DJ.reward(tempoAudio);
        //paro a reprodução
        mp3DJ.stop();
    }

    @Override
    public void avancar(int posicao) {
        mp3DJ.forward(posicao);
    }

    @Override
    public void retornar(int posicao) {
        mp3DJ.reward(posicao);
    }

    @Override
    public void liberar() {
        try {
            //seto o objeto nulo.
            tempoAudio = 0;
            mp3DJ.reward(tempoAudio);
            mp3DJ.finalize();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

}
