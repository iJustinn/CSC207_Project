package interface_adapter.search_album;

import entity.album.AlbumSimple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchAlbumStateTest {
    private SearchAlbumState state;

    @BeforeEach
    void setUp() {
        state = new SearchAlbumState();
    }

    @Test
    void testSetAndGetSearchInput() {
        String searchInput = "Test Input";
        state.setSearchInput(searchInput);
        assertEquals(searchInput, state.getSearchInput());
    }

    @Test
    void testSetAndGetAlbums() {
        List<AlbumSimple> albums = new ArrayList<>();
        state.setAlbums(albums);
        assertEquals(albums, state.getAlbums());
    }
}
