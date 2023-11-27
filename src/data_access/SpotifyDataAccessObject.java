package data_access;


// These two imports are for accessing albums through the Spotify API

import entity.album.AlbumFull;
import entity.album.AlbumSimple;
import entity.album.AlbumFactory;

import entity.artist.ArtistSimple;
import entity.artist.ArtistFull;

import entity.Song.SongFull;

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
