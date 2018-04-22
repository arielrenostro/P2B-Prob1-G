package br.furb.programcaoii.problema1.adapter;

import br.furb.programcaoii.problema1.target.FormatoAudio;
import problema1.WAVPlayer;

/**
 * WAVPlayerAdapter tem como objetivo definir a camada Adapter do {@link WAVPlayer} utilizando como Target {@link FormatoAudio}
 * 
 * @author ariel
 *
 */
public class WAVPlayerAdapter implements FormatoAudio {

	private WAVPlayer wavPlayer = null;
	private int tempoAudio = 0;
	private boolean tocando = false;
	
	@Override 
	public void abrir(String caminho){
		this.wavPlayer = new WAVPlayer(caminho);
		this.tocando = false;
		resetarTempoAudio();
	}
	
	private void resetarTempoAudio() {
		this.tempoAudio = 0;
	}

	@Override 
	public void reproduzir(){
		definirTempoCorretoParaReproducao();
		this.wavPlayer.play();
		this.tocando = true;
	}

	private void definirTempoCorretoParaReproducao() {
		int dif = getTempoAtualPlayer() - this.tempoAudio;
		if (0 < dif) {
			this.wavPlayer.reward(dif);
		} else {
			this.wavPlayer.forward(dif * -1);
		}
		
	}

	@Override 
	public void pausar() {
		this.wavPlayer.stop();
		this.tempoAudio = getTempoAtualPlayer();
		this.tocando = false;
	}

	private int getTempoAtualPlayer() {
		return this.wavPlayer.forward(0);
	}

	@Override 
	public void parar() {
		this.wavPlayer.stop();
		this.tocando = false;
		resetarTempoAudio();
	}

	@Override 
	public void avancar(int posicao) {
		boolean tocando = this.tocando;
		if (tocando) {
			pausar();
		}
		
		this.tempoAudio += posicao * 1000;
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
	public void retornar(int posicao) {
		boolean tocando = this.tocando;
		if (tocando) {
			pausar();
		}
		
		this.tempoAudio -= posicao * 1000;
		validarTempoAudio();
		
		if (tocando) {
			reproduzir();
		}
	}

	@Override 
	public void liberar() {
		parar();
		this.wavPlayer = null;
		this.tocando = false;
	}

}
