package br.furb.programcaoii.problema1.adapter;

import br.furb.programcaoii.problema1.target.FormatoAudio;
import problema1.WAVPlayer;

public class WAVPlayerAdapter extends WAVPlayer implements FormatoAudio {

	public WAVPlayerAdapter(String file) {
		super(file);
	}

	@Override 
	public void abrir(String caminho){
		// TODO Auto-generated method stub
	}

	@Override 
	public void reproduzir(){
		// TODO Auto-generated method stub
	}

	@Override 
	public void pausar(){
		// TODO Auto-generated method stub
	}

	@Override 
	public void parar(){
		// TODO Auto-generated method stub
	}

	@Override 
	public void avancar(int posicao){
		// TODO Auto-generated method stub
	}

	@Override 
	public void retornar(int posicao){
		// TODO Auto-generated method stub
	}

	@Override 
	public void liberar(){
		// TODO Auto-generated method stub
	}

}
