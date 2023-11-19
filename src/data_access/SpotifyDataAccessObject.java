package data_access;


// These two imports are for accessing albums through the Spotify API

import entity.album.AlbumFull;
import entity.album.AlbumSimple;
import entity.artist.ArtistFull;

import entity.artist.ArtistSimple;
import entity.song.SongFull;
import entity.song.SongSimple;
import spotify.SpotifyEndpoint;
import use_case.search.SearchDataAccessInterface;
import use_case.get_by_id.GetByIdDataAccessInterface;

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
    public AlbumFull[] getAlbumById(String albumId) {
        return new AlbumFull[0];
    }

    @Override
    public ArtistFull[] getArtistById(String artistId) {
        return new ArtistFull[0];
    }

    @Override
    public SongFull[] getSongById(String songId) {
        return new SongFull[0];
    }

    @Override
    public AlbumSimple[] searchAlbumsByName(String albumName) {
        return new AlbumSimple[0];
    }

    @Override
    public ArtistSimple[] searchArtistByName(String artistName) {
        return new ArtistSimple[0];
    }

    @Override
    public SongSimple[] searchSongByName(String songName) {
        return new SongSimple[0];
    }
}
