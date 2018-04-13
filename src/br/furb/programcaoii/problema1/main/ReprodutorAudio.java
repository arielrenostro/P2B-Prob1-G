package br.furb.programcaoii.problema1.main;

import problema1.AIFFSuperPlayer;
import problema1.WAVPlayer;
import problema1.wmaPlay;

public class ReprodutorAudio implements FormatoAudio {

	private AIFFSuperPlayer aiffPlayer;
	private WAVPlayer wavPlayer;
	private wmaPlay wmaPlayer;

	private TipoArquivo tipoArquivo;
	private int tempoAudio = 0;
	private String caminho;

	@Override
	public void abrir(String caminho) {
		this.caminho = caminho;
		instanciarPlayers();
	}

	private void instanciarPlayers() {
		resetarPlayers();

		String identificador = Util.isNotEmpty(caminho) ? caminho.toLowerCase() : "";

		if (identificador.endsWith(".aiff")) {
			tipoArquivo = TipoArquivo.AIFF;
			aiffPlayer = new AIFFSuperPlayer(caminho);
		} else if (identificador.endsWith(".wav")) {
			tipoArquivo = TipoArquivo.WAV;
			wavPlayer = new WAVPlayer(caminho);
		} else if (identificador.endsWith(".wma")) {
			tipoArquivo = TipoArquivo.WMA;
			wmaPlayer = new wmaPlay();
			wmaPlayer.setFile(caminho);
			wmaPlayer.open();
		}
	}

	private void resetarPlayers() {
		aiffPlayer = null;
		wavPlayer = null;
		wmaPlayer = null;
	}

	@Override
	public void reproduzir() {
		
		switch (tipoArquivo) {
			case AIFF:
				reproduzirAiff();
				break;
			case WAV:
				reproduzirWav();
				break;
			case WMA:
				reproduzirWma();
				break;
			default:
				break;
		}
	}

	private void reproduzirAiff() {
		aiffPlayer.setCursor(tempoAudio);
		aiffPlayer.play();
	}

	private void reproduzirWav() {
		setarTempoCorretoWav();
		wavPlayer.play();
	}

	private void setarTempoCorretoWav() {
		int difTempo = (wavPlayer.forward(0) / 1000) - tempoAudio;
		if (difTempo > 0) {
			wavPlayer.forward(difTempo * 1000);
		} else {
			wavPlayer.reward(difTempo / 1000);
		}
	}

	private void reproduzirWma() {
		wmaPlayer.setLocation(tempoAudio);
		wmaPlayer.play();
	}

	@Override
	public void pausar() {
		switch (tipoArquivo) {
			case AIFF:
				pausarAiff();
				break;
			case WAV:
				pausarWav();
				break;
			case WMA:
				pausarWma();
				break;
			default:
				break;
		}
	}

	private void pausarAiff() {
		tempoAudio = aiffPlayer.pause();
	}

	private void pausarWav() {
		wavPlayer.stop();
		tempoAudio = wavPlayer.forward(0) / 1000;
	}

	private void pausarWma() {
		wmaPlayer.stop();
		tempoAudio = wmaPlayer.getLocation();
	}

	@Override
	public void parar() {
		switch (tipoArquivo) {
			case AIFF:
				pararAiff();
				break;
			case WAV:
				pararWav();
				break;
			case WMA:
				pararWma();
				break;
			default:
				break;
		}
		tempoAudio = 0;
	}

	private void pararAiff() {
		aiffPlayer.stop();
	}

	private void pararWav() {
		wavPlayer.stop();
	}

	private void pararWma() {
		wmaPlayer.stop();
	}

	@Override
	public void avancar(int posicao) {
		if (posicao > 0) {
                tempoAudio += posicao;
        } 
		switch (tipoArquivo) {
			case AIFF:
				avancarAiff();
				break;
			case WAV:
				avancarWav(posicao);
				break;
			case WMA:
				avancarWma();
				break;
			default:
				break;
		}
	}

	private void avancarAiff() {
		aiffPlayer.setCursor(tempoAudio);
	}

	private void avancarWav(int posicao) {
		wavPlayer.forward(posicao * 1000);
	}

	private void avancarWma() {
		wmaPlayer.setLocation(tempoAudio);
	}

	@Override
	public void retornar(int posicao) {
		tempoAudio -= posicao;
		if (0 > tempoAudio) {
			tempoAudio = 0;
		}
		switch (tipoArquivo) {
			case AIFF:
				retornarAiff();
				break;
			case WAV:
				retornarWav(posicao);
				break;
			case WMA:
				retornarWma();
				break;
			default:
				break;
		}
	}

	private void retornarAiff() {
		aiffPlayer.setCursor(tempoAudio);
	}

	private void retornarWav(int posicao) {
		wavPlayer.reward(posicao * 1000);
	}

	private void retornarWma() {
		wmaPlayer.setLocation(tempoAudio);
	}

	@Override
	public void liberar() {
		switch (tipoArquivo) {
			case AIFF:
				liberarAiff();
				break;
			case WAV:
				liberarWav();
				break;
			case WMA:
				liberarWma();
				break;
			default:
				break;
		}
	}

	private void liberarAiff() {
		parar();
		aiffPlayer.release();
	}

	private void liberarWav() {
		parar();
		wavPlayer = null;
	}

	private void liberarWma() {
		parar();
		wmaPlayer = null;
	}

}
