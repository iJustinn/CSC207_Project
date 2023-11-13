package use_case.search.search_album;

import entity.album.AlbumSimple;

public class SearchAlbumOutputData {
    private final AlbumSimple[] albums;

    public SearchAlbumOutputData(AlbumSimple[] albums) {
        this.albums = albums;
    }

    public AlbumSimple[] getAlbums() {
        return albums;
    }
}
