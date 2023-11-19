package spotify;

import se.michaelthelin.spotify.SpotifyApi;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;

import spotify.models.*;

import java.util.Arrays;
import java.util.List;


public class SpotifyEndpoint {
    private final SpotifyApi spotifyApi;

    public SpotifyEndpoint() {
        String accessToken = System.getenv("API_KEY");
        spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();
    }

    public List<AlbumSimpleModel> requestSearchAlbum(String albumName) {
        SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(albumName).build();
        try {
            AlbumSimplified[] spotifyAlbums = searchAlbumsRequest.execute().getItems();
            return Arrays.stream(spotifyAlbums).map(AlbumSimpleModel::new).toList();
        } catch (Exception e) {
            System.out.println("Error in spotify");
        }
        return List.of();
    }

}