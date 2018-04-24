/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.programcaoii.problema1.adapter;
import br.furb.programcaoii.problema1.target.FormatoAudio;
import problema1.AACPlayer;
/**
 *
 * @author User
 */
//Favor arrumar
public class AACPlayerAdapter implements FormatoAudio {
    
    private AACPlayer player = null;
    private int location = 0;
    private boolean tocando;
    
    public AACPlayerAdapter(){
        super();
    }

    @Override
    public void abrir(String caminho) {
        this.player = new AACPlayer(caminho);
        this.player.open();
        this.location = 0;
    }

    @Override
    public void reproduzir() {
        this.player.setLocation(location);
        this.player.play();
        this.tocando = true;
        
    }

    @Override
    public void pausar() {
        if(this.tocando){
            this.player.stop();
            this.location = player.getLocation();
            this.tocando = false;
        }
    }

    @Override
    public void parar() {
        this.player.stop();
        this.tocando = false;
        this.location = 0;
    }

    @Override
    public void avancar(int posicao) {
        
        boolean tocando = this.tocando;
        
        if(tocando)
            pausar();
        
        this.location += posicao;
        this.player.setLocation(this.location);
        
        if(tocando)
            reproduzir();

    }

    @Override
    public void retornar(int posicao) {
        
        boolean tocando = this.tocando;
        
        if(tocando)
            pausar();
        
        this.location -= posicao;
        this.player.setLocation(this.location);
        
        if(tocando)
            reproduzir();
        
    }

    @Override
    public void liberar() {
        parar();
        this.player = null;
    }
    
}
