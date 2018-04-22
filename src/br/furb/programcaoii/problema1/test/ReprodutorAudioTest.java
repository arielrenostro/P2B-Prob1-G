package br.furb.programcaoii.problema1.test;

import org.junit.Test;

import br.furb.programcaoii.problema1.adapter.AIFFSuperPlayerAdapter;
import br.furb.programcaoii.problema1.adapter.WAVPlayerAdapter;
import br.furb.programcaoii.problema1.target.FormatoAudio;

public class ReprodutorAudioTest {

	@Test
	public void aiffTest01() {
		FormatoAudio formatoAudio = new AIFFSuperPlayerAdapter();
		
		formatoAudio.abrir("asdasd.aiff");
		formatoAudio.reproduzir();
		formatoAudio.pausar();
		formatoAudio.reproduzir();
		formatoAudio.parar();
		formatoAudio.reproduzir();
		formatoAudio.parar();
		formatoAudio.reproduzir();
		formatoAudio.avancar(10);
		formatoAudio.reproduzir();
		formatoAudio.retornar(20);
		formatoAudio.parar();
	}
	
	@Test
	public void wavTest01() {
		FormatoAudio formatoAudio = new WAVPlayerAdapter();
		
		formatoAudio.abrir("asdasd.wav");
		formatoAudio.reproduzir();
		formatoAudio.pausar();
		formatoAudio.reproduzir();
		formatoAudio.parar();
		formatoAudio.reproduzir();
		formatoAudio.parar();
		formatoAudio.reproduzir();
		formatoAudio.avancar(10);
		formatoAudio.reproduzir();
		formatoAudio.retornar(20);
		formatoAudio.parar();
	}
}
