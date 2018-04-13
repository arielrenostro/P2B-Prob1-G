package br.furb.programcaoii.problema1.main;

public class Main {
public static void main(String[] args) {
        ReprodutorAudio ra = new ReprodutorAudio();
        ra.abrir("teste.aiff");
        ra.reproduzir();
        ra.avancar(5);
        ra.retornar(1);
        ra.pausar();        
        ra.parar();        
        ra.liberar();
        ReprodutorAudio ra1 = new ReprodutorAudio();
        ra1.abrir("teste.wav");
        ra1.reproduzir();
        ra1.pausar();
        ra1.reproduzir();
        ra1.parar();
        ra1.reproduzir();
        ReprodutorAudio ra2 = new ReprodutorAudio();
        ra2.abrir("teste.wma");
        ra2.reproduzir();
        ra2.avancar(5);
        ra2.retornar(1);
        ra2.pausar();
        ra2.parar();        
        ra2.liberar();
        
    }
}
