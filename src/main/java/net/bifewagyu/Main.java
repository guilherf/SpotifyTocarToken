package net.bifewagyu;

import net.bifewagyu.config.SpotifyToken;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o token do client: ");
        String token = sc.nextLine();

        SpotifyToken.inicializateApi(token);
        SpotifyToken.slaPorra();

//        System.out.println("Digite a musica: ");
//        String musica = sc.nextLine();
//        SpotifyToken.darPlay(musica);



    }
}