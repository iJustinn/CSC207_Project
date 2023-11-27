package data_access;


// These two imports are for accessing albums through the Spotify API

import entity.album.AlbumFull;
import entity.album.AlbumSimple;

import entity.artist.ArtistSimple;
import entity.artist.ArtistFull;

import entity.song.SongFull;
import entity.song.SongSimple;

import spotify.SpotifyEndpoint;
import spotify.models.AlbumSimpleModel;
import use_case.search.SearchDataAccessInterface;
import use_case.get_by_id.GetByIdDataAccessInterface;

import java.util.Arrays;
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
    public List<AlbumSimple> searchAlbumsByName(String albumName) {
        try {
            List<AlbumSimpleModel> spotifyAlbums = this.spotifyApi.searchAlbum(albumName);
            return spotifyAlbums.stream().map(AlbumSimple::new).toList();
        } catch (Exception e) {
            a
        }

    }

    @Override
    public List<ArtistSimple> searchArtistByName(String artistName) {
        return List.of();
    }

    @Override
    public List<SongSimple> searchSongByName(String songName) {
        return List.of();
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
    public SongFull getSongById(String songId) {
        return null;
    }
}
