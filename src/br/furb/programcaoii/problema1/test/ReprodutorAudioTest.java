package br.furb.programcaoii.problema1.test;

import org.junit.Test;

import br.furb.programcaoii.problema1.main.ReprodutorAudio;

public class ReprodutorAudioTest {

	@Test
	public void test001() {
		ReprodutorAudio teste = new ReprodutorAudio();
		teste.abrir("teste.wav");
		
		teste.reproduzir();
		teste.pausar();
		teste.reproduzir();
		teste.parar();
		teste.reproduzir();
	}
}
