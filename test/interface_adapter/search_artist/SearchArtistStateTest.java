package interface_adapter.search_artist;

import entity.album.AlbumSimple;
import entity.artist.ArtistFull;
import interface_adapter.search_album.SearchAlbumState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchArtistStateTest {
    private SearchArtistState state;

    @BeforeEach
    void setUp() {
        state = new SearchArtistState();
    }

    @Test
    void testSetAndGetSearchInput() {
        String searchInput = "Test Input";
        state.setSearchInput(searchInput);
        assertEquals(searchInput, state.getSearchInput());
    }

    @Test
    void testSetAndGetArtist() {
        List<ArtistFull> albums = new ArrayList<>();
        state.setArtists(albums);
        assertEquals(albums, state.getArtists());
    }
}