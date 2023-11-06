package data_access;

import entity.Album;
import entity.AlbumFactory;
import use_case.search_album.SearchAlbumDataAccessInterface;

// These two imports are for accessing albums through the Spotify API
import spotify.services.SearchAlbumService;
import spotify.models.AlbumDto;

public class SpotifyDataAccessObject implements SearchAlbumDataAccessInterface {

    private final SearchAlbumService searchAlbum = new SearchAlbumService();
    private final AlbumFactory albumFactory;

    public SpotifyDataAccessObject(AlbumFactory albumFactory) {
        this.albumFactory = albumFactory;
    }

    @Override
    public Album[] searchAlbumsByString(String albumName) {
        // Returns a list of AlbumDto
        AlbumDto[] albums = searchAlbum.requestSearchAlbum(albumName);
        return albumFactory.createMany(albums);
    }
}
