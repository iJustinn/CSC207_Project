package interface_adapter.search_album;

import entity.album.IAlbumSimple;

import java.util.ArrayList;
import java.util.List;

public class SearchAlbumState {
    private List<IAlbumSimple> albums = new ArrayList<IAlbumSimple>();
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

    public List<IAlbumSimple> getAlbums() {
        return albums;
    }

    public void setAlbums(List<IAlbumSimple> albums) {
        this.albums = albums;
    }
}