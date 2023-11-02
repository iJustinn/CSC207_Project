package data_access;

import entity.Album;
import entity.AlbumFactory;
import use_case.search_album.SearchAlbumDataAccessInterface;

import spotify.services.SearchAlbumService;
import spotify.models.AlbumDto;

public class SpotifyDataAccessObject implements SearchAlbumDataAccessInterface {
    private AlbumFactory albumFactory;

    public SpotifyDataAccessObject(AlbumFactory albumFactory) {
        this.albumFactory = albumFactory;
    }
    @Override
    public Album[] searchAlbumsByString(String albumName) {
        SearchAlbumService searchAlbumService;
        searchAlbumService = new SearchAlbumService();
        AlbumDto[] a = searchAlbumService.requestSearchAlbum(albumName);
        Album[] albums = new Album[a.length];
        for (int i = 0; i < a.length; i++) {
            albums[i] = albumFactory.create(a[i].getId(), a[i].getAlbumName(), a[i].getReleaseDate());
        }

        return albums;
    }
}
