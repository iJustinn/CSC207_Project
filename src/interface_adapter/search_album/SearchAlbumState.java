package interface_adapter.search_album;

import entity.album.AlbumSimple;

public class SearchAlbumState {
    private AlbumSimple[] albums = null;
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

    public AlbumSimple[] getAlbums() {
        return albums;
    }

    public void setAlbums(AlbumSimple[] albums) {
        this.albums = albums;
    }
}