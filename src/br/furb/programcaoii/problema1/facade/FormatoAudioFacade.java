package br.furb.programcaoii.problema1.facade;

import br.furb.programcaoii.problema1.target.FormatoAudio;

public class FormatoAudioFacade {
	
	private FormatoAudio formatoAudio;
	
	public void reproduzirSimples(String arquivo) {
            
            FormatoAudioFactory formato = new FormatoAudioFactory();
            this.formatoAudio = formato.getInstanciaFormatoAudio(arquivo);
            this.formatoAudio.abrir(arquivo);
            this.formatoAudio.reproduzir();
            
        }
       
	public void pararSimples() {
            
            this.formatoAudio.parar();
            this.formatoAudio.liberar();
            this.formatoAudio = null;
	}
}
  
