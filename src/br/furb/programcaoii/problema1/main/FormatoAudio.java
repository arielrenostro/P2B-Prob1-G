package br.furb.programcaoii.problema1.main;

public interface FormatoAudio {

	void abrir(String caminho);

	void reproduzir();

	void pausar();

	void parar();

	void avancar(int posicao);

	void retornar(int posicao);

	void liberar();

}
