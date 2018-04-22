package br.furb.programcaoii.problema1.adapter;

import br.furb.programcaoii.problema1.target.FormatoAudio;
import problema1.AIFFSuperPlayer;

/**
 * AIFFSuperPlayerAdapter tem como objetivo definir a camada Adapter do {@link AIFFSuperPlayer} utilizando como Target {@link FormatoAudio}
 * 
 * @author ariel
 *
 */
public class AIFFSuperPlayerAdapter implements FormatoAudio {

	private AIFFSuperPlayer aiffSuperPlayer = null;
	private int tempoAudio = 0;
	private boolean tocando = false;
	
	public AIFFSuperPlayerAdapter() {
		super();
	}

	@Override 
	public void abrir(String caminho){
		this.aiffSuperPlayer = new AIFFSuperPlayer(caminho);
		this.tocando = false;
		resetarTempoAudio();
	}

	private void resetarTempoAudio() {
		this.tempoAudio = 0;
	}

	@Override 
	public void reproduzir(){
		this.aiffSuperPlayer.setCursor(tempoAudio);
		this.aiffSuperPlayer.play();
		this.tocando = true;
	}

	@Override 
	public void pausar(){
		this.tempoAudio = this.aiffSuperPlayer.pause();
		this.tocando = false;
	}

	@Override 
	public void parar(){
		this.aiffSuperPlayer.stop();
		this.tocando = false;
		resetarTempoAudio();
	}

	@Override 
	public void avancar(int posicao) {
		boolean tocando = this.tocando;
		if (tocando) {
			pausar();
		}
		
		this.tempoAudio += posicao;
		validarTempoAudio();
		
		if (tocando) {
			reproduzir();
		}
	}

	private void validarTempoAudio() {
		if (0 > this.tempoAudio) {
			resetarTempoAudio();
		}
	}

	@Override 
	public void retornar(int posicao){
		boolean tocando = this.tocando;
		if (tocando) {
			pausar();
		}
		
		this.tempoAudio -= posicao;
		
		validarTempoAudio();
		if (tocando) {
			reproduzir();
		}
	}

	@Override 
	public void liberar(){
		parar();
		this.aiffSuperPlayer.release();
		this.aiffSuperPlayer = null;
		this.tocando = false;
	}

}
