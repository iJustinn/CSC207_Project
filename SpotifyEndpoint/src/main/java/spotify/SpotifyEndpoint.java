package spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;

import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchAlbumsRequest;

import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;

import spotify.models.*;
import se.michaelthelin.spotify.model_objects.specification.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class SpotifyEndpoint {
    private final SpotifyApi spotifyApi;

    public SpotifyEndpoint() {
        String accessToken = System.getenv("API_KEY");
        spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();
    }

    public List<AlbumSimpleModel> searchAlbum(String q)
            throws IOException, SpotifyWebApiException, ParseException {
        SearchAlbumsRequest request = spotifyApi.searchAlbums(q).build();
        AlbumSimplified[] albums = request.execute().getItems();
        return Arrays.stream(albums).map(AlbumSimpleModel::new).toList();
    }

    public List<ArtistModel> searchArtist(String q)
            throws IOException, SpotifyWebApiException, ParseException {
        SearchArtistsRequest request = spotifyApi.searchArtists(q).build();
        Artist[] artists = request.execute().getItems();
        return Arrays.stream(artists).map(ArtistModel::new).toList();
    }

    public List<TrackModel> searchTrack(String q)
            throws IOException, SpotifyWebApiException, ParseException {
        SearchTracksRequest request = spotifyApi.searchTracks(q).build();
        Track[] tracks = request.execute().getItems();
        return Arrays.stream(tracks).map(TrackModel::new).toList();
    }

}