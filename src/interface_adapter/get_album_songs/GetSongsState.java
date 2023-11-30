package interface_adapter.get_album_songs;

import entity.song.Song;

import java.util.ArrayList;
import java.util.List;

public class GetSongsState {
    private List<Song> songs = new ArrayList<>();
    private String searchId = null;

    public GetSongsState() {}
    public GetSongsState(GetSongsState copy) {
        songs = copy.songs;
        searchId = copy.searchId;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
