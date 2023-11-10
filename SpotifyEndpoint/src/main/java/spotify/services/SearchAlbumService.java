package spotify.services;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;

import java.io.IOException;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import spotify.models.AlbumDto;


public class SearchAlbumService {
    private final SpotifyApi spotifyApi;

    public SearchAlbumService() {
        String accessToken = System.getenv("API_KEY");
        spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();
    }

    public AlbumDto[] requestSearchAlbum(String albumName) {
        AlbumDto[] albums = {};
        try {
            SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(albumName).build();
            AlbumSimplified[] spotifyAlbums = searchAlbumsRequest.execute().getItems();

            albums = new AlbumDto[spotifyAlbums.length];

            for (int i = 0; i < spotifyAlbums.length; i++)  {
                AlbumSimplified album = spotifyAlbums[i];
                AlbumDto albumDto = new AlbumDto(album.getId(), album.getName(), album.getReleaseDate());
                albums[i] = albumDto;
            }
        } catch (IOException | SpotifyWebApiException | ParseException e) {  // needs work

        }
        return albums;
    }
}
