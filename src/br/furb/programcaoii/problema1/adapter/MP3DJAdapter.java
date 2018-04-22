package br.furb.programcaoii.problema1.adapter;

import br.furb.programcaoii.problema1.target.FormatoAudio;
import java.util.logging.Level;
import java.util.logging.Logger;
import problema1.MP3DJ;
/**
 *
 * @author silvinos
 */
public class MP3DJAdapter extends MP3DJ implements FormatoAudio {

    //Atributos da classe    
    private int tempoAudio;

    @Override
    public void abrir(String caminho) {
        //passo o caminho para o metodo setFile para setar o arquivo  
        this.setFile(caminho);
    }

    @Override
    public void reproduzir() {        
        this.play();
    }

    @Override
    public void pausar() {
        //paro a reprodução
        this.stop();
        //passo para o atributo tempoAudio o valor da posição em que está
        tempoAudio = this.forward(0);
    }

    @Override
    public void parar() {
        //retrocedo o tempo da reprodução para o inicio.
        this.reward(tempoAudio);
        //paro a reprodução
        this.stop();
    }

    @Override
    public void avancar(int posicao) {
        this.forward(posicao);
    }

    @Override
    public void retornar(int posicao) {
        this.reward(posicao);
    }

    @Override
    public void liberar() {
        try {
            //seto o objeto nulo.
            tempoAudio = 0;
            this.reward(tempoAudio);
            this.finalize();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

}
