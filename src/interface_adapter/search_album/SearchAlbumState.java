package interface_adapter.search_album;

import entity.album.AlbumSimple;

import java.util.ArrayList;
import java.util.List;

public class SearchAlbumState {
    private List<AlbumSimple> albums = new ArrayList<AlbumSimple>();
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

    public List<AlbumSimple> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumSimple> albums) {
        this.albums = albums;
    }
}