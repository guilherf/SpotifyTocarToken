package net.bifewagyu.config;

import com.google.gson.JsonArray;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.User;
import se.michaelthelin.spotify.requests.data.player.StartResumeUsersPlaybackRequest;
import se.michaelthelin.spotify.requests.data.users_profile.GetUsersProfileRequest;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class SpotifyToken {


   static SpotifyApi spotifyApi;



    public static void inicializateApi(String accessToken) {

      spotifyApi =  SpotifyApi.builder()
                .setAccessToken(accessToken)
                .build();


    }



    public static String pegarID(){

        String id = null;

        try {


            var getUserID = spotifyApi.getCurrentUsersProfile().build();
            var user = getUserID.execute();



              id = user.getId();


        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Erro ao pegar ID: " + e.getMessage());
        }


        return id;


    }


    public static void nomeDaPessoa() {


        GetUsersProfileRequest requestProfile = spotifyApi.getUsersProfile(pegarID()).build();

        try {


            final User user = requestProfile.execute();

            System.out.println("Nome do usuario " + user.getDisplayName());


        } catch (IOException | SpotifyWebApiException | ParseException e) {

            System.out.println("Erro do perfil " + e.getMessage());

        }

        try {
            CompletableFuture<User> userFuture = requestProfile.executeAsync();

            User user = userFuture.join();


            System.out.println("Nome do usuario " + user.getDisplayName());
        }catch (CancellationException e){

            System.out.println("Erro" + e.getMessage());

        } catch (CompletionException e) {
            System.out.println("Erro" + e.getCause().getMessage());
        }



    }



    public static void darPlay(String trackUri) {
        try {

            JsonArray array = new JsonArray();

            array.add(trackUri);

            StartResumeUsersPlaybackRequest playSpot = spotifyApi.startResumeUsersPlayback()
                    .uris(array)
                    .build();


            playSpot.execute();
            System.out.println("Playing Spotify sound " + playSpot.getContentType());

        } catch (IOException | SpotifyWebApiException | ParseException e) {

            System.out.println("Erro ao tocar musica: " + e.getMessage());

        }
    }




}
