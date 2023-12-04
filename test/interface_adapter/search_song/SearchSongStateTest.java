package interface_adapter.search_song;

import org.junit.jupiter.api.Test;
import entity.song.Song;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchSongStateTest {

    @Test
    void setAndGetSongs() {
        SearchSongState state = new SearchSongState();
        List<Song> mockSongs = List.of(new Song());
        state.setSongs(mockSongs);
        assertEquals(state.getSongs(), mockSongs);
    }

    @Test
    void setAndGetSearchInput() {
        SearchSongState state = new SearchSongState();
        String searchInput = "Test Query";
        state.setSearchInput(searchInput);
        assertEquals(state.getSearchInput(), searchInput);
    }
}
