package interface_adapter.search_artist;

import entity.artist.ArtistFull;

import java.util.ArrayList;
import java.util.List;

public class SearchArtistState {
    private List<ArtistFull> artists = new ArrayList<>();
    private String searchInput = null;

    public SearchArtistState() {}


    public String getSearchInput() {
        return searchInput;
    }

    public void setArtists(List<ArtistFull> artists) {
        this.artists = artists;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public List<ArtistFull> getArtists() {
        return artists;
    }
}
