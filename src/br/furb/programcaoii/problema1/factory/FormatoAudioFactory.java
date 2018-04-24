package br.furb.programcaoii.problema1.factory;

import br.furb.programcaoii.problema1.target.FormatoAudio;
import br.furb.programcaoii.problema1.util.Util;
import br.furb.programcaoii.problema1.adapter.AIFFSuperPlayerAdapter;
import br.furb.programcaoii.problema1.adapter.WAVPlayerAdapter;
import br.furb.programcaoii.problema1.adapter.WmaPlayAdapter;
import br.furb.programcaoii.problema1.adapter.AACPlayerAdapter;
import br.furb.programcaoii.problema1.adapter.MP3DJAdapter;

/**
 *
 * @author silvinos
 */   
public class FormatoAudioFactory {
	
	public static FormatoAudio getInstanciaFormatoAudio(String arquivo) {
        String identificador = Util.isNotEmpty(arquivo) ? arquivo.toLowerCase() : "";
        
        if (identificador.endsWith(".aiff")) {
            return new AIFFSuperPlayerAdapter();
        } else if (identificador.endsWith(".wav")) {
            return new WAVPlayerAdapter();
        } else if (identificador.endsWith(".wma")) {                		
            return new WmaPlayAdapter();
        } else if (identificador.endsWith(".mp3")){
            return new MP3DJAdapter();
        } else if (identificador.endsWith(".aac")){
            return new AACPlayerAdapter();
        }
            
        throw new IllegalArgumentException("Tipo de audio não suportado");            	
	}
}
