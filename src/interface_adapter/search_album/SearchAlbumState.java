package interface_adapter.search_album;

import entity.Album;

public class SearchAlbumState {
    private Album[] albums = null;

    public SearchAlbumState(SearchAlbumState copy) {
        albums = copy.albums;
    }

    public SearchAlbumState() { }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }
}
