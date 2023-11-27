package use_case.search.search_song;

import java.util.List;
import entity.song.Song;

public class SearchSongOutputData {
    private final List<Song> songs;

    public SearchSongOutputData(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
