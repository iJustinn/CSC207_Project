package interface_adapter.search_song;

import entity.song.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchSongState {
    private List<Song> songs = new ArrayList<>();
    private String searchInput = null;

    public SearchSongState() {}

    public SearchSongState(SearchSongState copy) {
        songs = copy.songs;
        searchInput = copy.searchInput;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
