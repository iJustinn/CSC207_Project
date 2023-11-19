package spotify;

import se.michaelthelin.spotify.SpotifyApi;

import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;

import spotify.models.*;


public class SpotifyEndpoint {
    private final SpotifyApi spotifyApi;

    public SpotifyEndpoint() {
        String accessToken = System.getenv("API_KEY");
        spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();
    }

    public AlbumSimpleModel[] requestSearchAlbum(String albumName) {
        SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(albumName).build();
        // AlbumSimplified[] spotifyAlbums = searchAlbumsRequest.execute().getItems();
        return new AlbumSimpleModel[] {};
    }

}