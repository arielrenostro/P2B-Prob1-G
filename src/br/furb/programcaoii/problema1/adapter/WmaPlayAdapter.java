package br.furb.programcaoii.problema1.adapter;

import br.furb.programcaoii.problema1.target.FormatoAudio;
import problema1.wmaPlay;

public class WmaPlayAdapter extends wmaPlay implements FormatoAudio {

	private int posicaoPausa = 0;


	@Override
	public void abrir(String caminho) {
		setFile(caminho);
		setLocation(0);
		open();
	}

	@Override
	public void reproduzir() {
		if (posicaoPausa != 0) {
			setLocation(posicaoPausa);
			posicaoPausa = 0;
		}
		play();
	}

	@Override
	public void pausar() {
		posicaoPausa = getLocation();
		stop();

	}

	@Override
	public void parar() {
		posicaoPausa = 0;
		stop();
		setLocation(0);
	}

	@Override
	public void avancar(int posicao) {
		if (posicaoPausa != 0){
			setLocation(posicaoPausa + posicao);
		}else
			setLocation(getLocation() + posicao);
	}

	@Override
	public void retornar(int posicao) {
		int valor = 0;
		
		if (posicaoPausa != 0){
			valor = posicaoPausa - posicao;
		}else
			valor = getLocation() - posicao;
		
		if (valor > 0) {
			setLocation(valor);
		} else {
			setLocation(0);
		}
	}

	@Override
	public void liberar() {
		stop();
		posicaoPausa = 0;
		try {
			finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
