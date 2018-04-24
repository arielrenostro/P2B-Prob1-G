package br.furb.programcaoii.problema1.test;

import org.junit.Assert;
import org.junit.Test;

import br.furb.programcaoii.problema1.adapter.AACPlayerAdapter;
import br.furb.programcaoii.problema1.adapter.AIFFSuperPlayerAdapter;
import br.furb.programcaoii.problema1.adapter.MP3DJAdapter;
import br.furb.programcaoii.problema1.adapter.WAVPlayerAdapter;
import br.furb.programcaoii.problema1.adapter.WmaPlayAdapter;
import br.furb.programcaoii.problema1.factory.FormatoAudioFactory;
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
	
	@Test
	public void mp3Test01() {
		MP3DJAdapter mp3 = new MP3DJAdapter();
		mp3.abrir("eminem.mp3");
       	mp3.reproduzir();
       	mp3.pausar();
       	mp3.reproduzir();
       	mp3.parar();
       	mp3.reproduzir();
	}
	
	@Test
	public void aacTeste01() {
		FormatoAudio formatoAudio = new AACPlayerAdapter();
		
		formatoAudio.abrir("asdasd.aac");
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
	public void factoryTest01() {
		FormatoAudio aac = FormatoAudioFactory.getInstanciaFormatoAudio("adisiasdoa.aac");
		Assert.assertEquals(AACPlayerAdapter.class, aac.getClass());
		
		aac = FormatoAudioFactory.getInstanciaFormatoAudio("adisiasdoa.aAC");
		Assert.assertEquals(AACPlayerAdapter.class, aac.getClass());
		
		aac = FormatoAudioFactory.getInstanciaFormatoAudio("adisiasdoa.AAC");
		Assert.assertEquals(AACPlayerAdapter.class, aac.getClass());
		
		FormatoAudio wma = FormatoAudioFactory.getInstanciaFormatoAudio("ansdoasod.wma");
		Assert.assertEquals(WmaPlayAdapter.class, wma.getClass());
		
		FormatoAudio mp3 = FormatoAudioFactory.getInstanciaFormatoAudio("ansdoasod.mp3");
		Assert.assertEquals(MP3DJAdapter.class, mp3.getClass());
		
		FormatoAudio wav = FormatoAudioFactory.getInstanciaFormatoAudio("ansdoasod.wav");
		Assert.assertEquals(WAVPlayerAdapter.class, wav.getClass());
		
		FormatoAudio aiff = FormatoAudioFactory.getInstanciaFormatoAudio("ansdoasod.aiff");
		Assert.assertEquals(AIFFSuperPlayerAdapter.class, aiff.getClass());
	}
}
