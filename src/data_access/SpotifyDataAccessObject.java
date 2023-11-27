package data_access;


// These two imports are for accessing albums through the Spotify API

import entity.album.AlbumFull;
import entity.album.AlbumSimple;

import entity.artist.ArtistFull;

import entity.song.Song;

import spotify.SpotifyEndpoint;
import spotify.models.*;
import use_case.search.SearchDataAccessInterface;
import use_case.get_by_id.GetByIdDataAccessInterface;

import java.util.List;

/**
 * A DataAccessObject used to get data from the Spotify API
 */
public class SpotifyDataAccessObject implements SearchDataAccessInterface, GetByIdDataAccessInterface {

    private final SpotifyEndpoint spotifyApi;

    public SpotifyDataAccessObject(SpotifyEndpoint spotifyApi) {
        this.spotifyApi = spotifyApi;
    }


    @Override
    public List<AlbumSimple> searchAlbumsByName(String name) {
        List<AlbumSimpleModel> albums = this.spotifyApi.searchAlbum(name);
        return albums.stream().map(AlbumSimple::new).toList();
    }

    @Override
    public List<ArtistFull> searchArtistByName(String name) {
        List<ArtistModel> artists = this.spotifyApi.searchArtist(name);
        return artists.stream().map(ArtistFull::new).toList();
    }

    @Override
    public List<Song> searchSongByName(String name) {
        List<TrackModel> songs = this.spotifyApi.searchTrack(name);
        return songs.stream().map(Song::new).toList();
    }

    @Override
    public AlbumFull getAlbumById(String albumId) {
        return null;
    }

    @Override
    public ArtistFull getArtistById(String artistId) {
        return null;
    }

    @Override
    public Song getSongById(String songId) {
        return null;
    }
}
