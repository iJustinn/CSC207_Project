package data_access;

import entity.Album;
import entity.AlbumFactory;
import use_case.search_album.SearchAlbumDataAccessInterface;

// These two imports are for accessing albums through the Spotify API
import spotify.services.SearchAlbumService;
import spotify.models.AlbumDto;

/**
 * A DataAccessObject used to get data from the Spotify API
 */
public class SpotifyDataAccessObject implements SearchAlbumDataAccessInterface {

    private final SearchAlbumService searchAlbum;
    private final AlbumFactory albumFactory;

    public SpotifyDataAccessObject(AlbumFactory albumFactory,
                                   SearchAlbumService searchAlbumService) {
        this.albumFactory = albumFactory;
        this.searchAlbum = searchAlbumService;
    }

    @Override
    public Album[] searchAlbumsByString(String albumName) {
        AlbumDto[] albums = searchAlbum.requestSearchAlbum(albumName);
        return albumFactory.createMany(albums);
    }
}
