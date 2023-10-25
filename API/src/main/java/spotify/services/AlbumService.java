package spotify.services;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.model_objects.specification.Album;

public class AlbumService {
    private final SpotifyApi spotifyApi;
    AlbumService(String accessToken) {
        spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
    }
    public Album requestAlbum(String id) {
        try {
            GetAlbumRequest getAlbumRequest = spotifyApi.getAlbum(id).build();
            return getAlbumRequest.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
