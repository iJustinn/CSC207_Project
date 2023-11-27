package spotify;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;

import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;
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

    public List<AlbumSimpleModel> searchAlbum(String q) {
        try {
            SearchAlbumsRequest request = spotifyApi.searchAlbums(q).build();
            AlbumSimplified[] albums = request.execute().getItems();
            return Arrays.stream(albums).map(AlbumSimpleModel::new).toList();
        } catch (Exception e) {
            System.out.println("Error in Spotify Endpoint: Search Album Request");
            return List.of();
        }
    }

    public List<ArtistModel> searchArtist(String q) {
        try {
            SearchArtistsRequest request = spotifyApi.searchArtists(q).build();
            Artist[] artists = request.execute().getItems();
            return Arrays.stream(artists).map(ArtistModel::new).toList();
        } catch (Exception e) {
            System.out.println("Error in Spotify Endpoint: Search Artist Request.");
            return List.of();
        }

    }

    public List<TrackModel> searchTrack(String q) {
        try {
            SearchTracksRequest request = spotifyApi.searchTracks(q).build();
            Track[] tracks = request.execute().getItems();
            return Arrays.stream(tracks).map(TrackModel::new).toList();
        } catch (Exception e) {
            System.out.println("Error in Spotify Endpoint: Search Track Request.");
            return List.of();
        }
    }

    public List<TrackSimpleModel> getAlbumTracks(String id) {
        try {
            GetAlbumsTracksRequest request = spotifyApi.getAlbumsTracks(id).build();
            TrackSimplified[] tracks = request.execute().getItems();
            return Arrays.stream(tracks).map(TrackSimpleModel::new).toList();
        } catch (Exception e) {
            System.out.println("Error in Spotify Endpoint: Get Album By Id Request.");
        return List.of();
        }
    }
}