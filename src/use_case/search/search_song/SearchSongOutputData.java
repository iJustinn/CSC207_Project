package use_case.search.search_song;

import java.util.List;

public class SearchSongOutputData {
    private final List<ISongSimple> songs;

    public SearchSongOutputData(List<ISongSimple> songs) {
        this.songs = songs;
    }

    public List<ISongSimple> getSongs() {
        return songs;
    }
}
