package use_case.view_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SongDTOTest {

    private SongDTO songDTO;
    private final String title = "Test Title";
    private final String id = "123";
    private final ArrayList<String> artist = new ArrayList<>(Arrays.asList("Artist 1", "Artist 2"));
    private final String album = "Test Album";
    private final String comment = "Test Comment";

    @BeforeEach
    void setUp() {
        songDTO = new SongDTO(title, id, artist, album, comment);
    }

    @Test
    void getTitle() {
        assertEquals(title, songDTO.getTitle());
    }

    @Test
    void getId() {
        assertEquals(id, songDTO.getId());
    }

    @Test
    void getArtist() {
        assertEquals(artist, songDTO.getArtist());
        assertTrue(songDTO.getArtist().contains("Artist 1"));
    }

    @Test
    void getAlbum() {
        assertEquals(album, songDTO.getAlbum());
    }

    @Test
    void getComment() {
        assertEquals(comment, songDTO.getComment());
    }
}
