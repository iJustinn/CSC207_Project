package interface_adapter.search_album;

import entity.album.Album;

public class SearchAlbumState {
    private Album[] albums = null;
    private String searchInput = null;

    public SearchAlbumState() {}
    public SearchAlbumState(SearchAlbumState copy) {
        albums = copy.albums;
        searchInput = copy.searchInput;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }
}