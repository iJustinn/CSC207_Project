package data_access;

import entity.album.AlbumSimple;

// These two imports are for accessing albums through the Spotify API
import spotify.services.SearchAlbumService;

import entity.artist.ArtistFull;
import use_case.search.SearchDataAccessInterface;

/**
 * A DataAccessObject used to get data from the Spotify API
 */
public class SpotifyDataAccessObject implements SearchDataAccessInterface {

    private final SearchAlbumService searchAlbum;
    private final AlbumFactory albumFactory;

    public SpotifyDataAccessObject(AlbumFactory albumFactory,
                                   SearchAlbumService searchAlbumService) {
        this.albumFactory = albumFactory;
        this.searchAlbum = searchAlbumService;
    }

    @Override
    public AlbumSimple[] searchAlbumsByName(String albumName) {
        return new AlbumSimple[0];
    }

    @Override
    public ArtistFull[] searchArtistByName(String artistName) {
        return new ArtistFull[0];
    }
}
