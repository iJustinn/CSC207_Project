package use_case.search_album;

import entity.album.Album;

public class SearchAlbumOutputData {
    private final Album[] albums;

    public SearchAlbumOutputData(Album[] albums) {
        this.albums = albums;
    }

    public Album[] getAlbums() {
        return albums;
    }
}
