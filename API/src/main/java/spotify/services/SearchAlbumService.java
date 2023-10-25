package spotify.services;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;

public class SearchAlbumService {
    private final SpotifyApi spotifyApi;
    SearchAlbumService(String accessToken) {
        spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
    }

    public AlbumSimplified[] requestSearchAlbum(String albumName) {
        try {
            SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(albumName).build();
            return searchAlbumsRequest.execute().getItems();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
