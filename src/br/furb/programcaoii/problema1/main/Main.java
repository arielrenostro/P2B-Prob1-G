package br.furb.programcaoii.problema1.main;
import br.furb.programcaoii.problema1.adapter.MP3DJAdapter;

public class Main {
public static void main(String[] args) {
        
       MP3DJAdapter mp3 = new MP3DJAdapter();
       mp3.abrir("eminem.mp3");
       mp3.reproduzir();
       mp3.pausar();
       mp3.reproduzir();
       mp3.parar();
       mp3.reproduzir();
    }
}
