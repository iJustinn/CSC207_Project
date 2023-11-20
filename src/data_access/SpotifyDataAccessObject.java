package data_access;


// These two imports are for accessing albums through the Spotify API

import entity.album.IAlbumFull;
import entity.album.AlbumSimple;
import entity.album.AlbumFactory;

import entity.artist.IArtistFull;
import entity.artist.IArtistSimple;
import entity.song.SongFull;
import entity.song.SongSimple;

import spotify.SpotifyEndpoint;
import spotify.models.AlbumSimpleModel;
import use_case.search.SearchDataAccessInterface;
import use_case.get_by_id.GetByIdDataAccessInterface;

import java.util.List;

/**
 * A DataAccessObject used to get data from the Spotify API
 */
public class SpotifyDataAccessObject implements SearchDataAccessInterface, GetByIdDataAccessInterface {

    private final SpotifyEndpoint spotifyApi;
    private final AlbumFactory albumFactory;

    public SpotifyDataAccessObject(AlbumFactory albumFactory,
                                   SpotifyEndpoint spotifyApi) {
        this.albumFactory = albumFactory;
        this.spotifyApi = spotifyApi;
    }


    @Override
    public List<AlbumSimple> searchAlbumsByName(String albumName) {
        List<AlbumSimpleModel> spotifyAlbums = this.spotifyApi.requestSearchAlbum(albumName);
        return spotifyAlbums.stream().map(AlbumSimple::new).toList();
    }

    @Override
    public List<IArtistSimple> searchArtistByName(String artistName) {
        return List.of();
    }

    @Override
    public List<SongSimple> searchSongByName(String songName) {
        return List.of();
    }

    @Override
    public IAlbumFull getAlbumById(String albumId) {
        return null;
    }

    @Override
    public IArtistFull getArtistById(String artistId) {
        return null;
    }

    @Override
    public SongFull getSongById(String songId) {
        return null;
    }
}
