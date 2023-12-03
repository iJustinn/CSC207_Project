package entity.album;

import entity.artist.ArtistSimple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spotify.models.AlbumSimpleModel;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AlbumSimpleTest {
    private AlbumSimple albumSimple;
    private final String id = "1";
    private final String name = "Album Name";
    private final String releaseDate = "2021-01-01";
    private List<ArtistSimple> artists;

    @BeforeEach
    void setUp() {
        // Mock AlbumSimpleModel and its methods
        AlbumSimpleModel mockAlbumModel = mock(AlbumSimpleModel.class);
        when(mockAlbumModel.getId()).thenReturn(id);
        when(mockAlbumModel.getAlbumName()).thenReturn(name);
        when(mockAlbumModel.getReleaseDate()).thenReturn(releaseDate);

        // Mock the list of artists
        ArtistSimple artist1 = new ArtistSimple("2", "Artist One");
        ArtistSimple artist2 = new ArtistSimple("3", "Artist Two");
        artists = Arrays.asList(artist1, artist2);

        // Assuming AlbumSimpleModel has a method getArtists() that returns a list of artist models
        albumSimple = new AlbumSimple(mockAlbumModel);
    }

    @AfterEach
    void tearDown() {
        albumSimple = null;
    }

    @Test
    void getReleaseDate() {
        assertEquals(releaseDate, albumSimple.getReleaseDate(), "getReleaseDate should return the correct release date.");
    }

    @Test
    void getName() {
        assertEquals(name, albumSimple.getName(), "getName should return the correct name.");
    }

    @Test
    void getId() {
        assertEquals(id, albumSimple.getId(), "getId should return the correct ID.");
    }

    @Test
    void getArtists() {
        assertEquals(artists, albumSimple.getArtists(), "getArtists should return the correct list of artists.");
    }

    @Test
    void testToString() {
        assertEquals(name, albumSimple.toString(), "toString should return the name of the album.");
    }
}
