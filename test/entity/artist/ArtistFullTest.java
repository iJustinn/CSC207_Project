package entity.artist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spotify.models.ArtistModel;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ArtistFullTest {
    private ArtistFull artistFull;
    private final String id = "1";
    private final String name = "Artist Name";
    private final String[] genres = new String[]{"Genre1", "Genre2"};
    private final Integer popularity = 80;

    @BeforeEach
    void setUp() {
        artistFull = new ArtistFull(id, name, genres, popularity);
    }

    @AfterEach
    void tearDown() {
        artistFull = null;
    }

    @Test
    void constructorWithArtistModel() {
        // Create a mock ArtistModel
        ArtistModel mockArtistModel = Mockito.mock(ArtistModel.class);

        // Define behavior for the mock's methods
        when(mockArtistModel.getId()).thenReturn("1");
        when(mockArtistModel.getName()).thenReturn("Artist Name");
        when(mockArtistModel.getGenres()).thenReturn(new String[]{"Genre1", "Genre2"});
        when(mockArtistModel.getPopularity()).thenReturn(80);

        // Use the mock to create an instance of ArtistFull
        ArtistFull artistFull = new ArtistFull(mockArtistModel);

        // Verify that the fields are set correctly
        assertEquals("1", artistFull.getId(), "Constructor should set ID correctly");
        assertEquals("Artist Name", artistFull.getName(), "Constructor should set name correctly");
        assertArrayEquals(new String[]{"Genre1", "Genre2"}, artistFull.getGenres(), "Constructor should set genres correctly");
        assertEquals(80, artistFull.getPopularity(), "Constructor should set popularity correctly");
    }

    @Test
    void getId() {
        assertEquals(id, artistFull.getId(), "getId should return the correct ID.");
    }

    @Test
    void getName() {
        assertEquals(name, artistFull.getName(), "getName should return the correct name.");
    }

    @Test
    void getGenres() {
        assertArrayEquals(genres, artistFull.getGenres(), "getGenres should return the correct genres.");
    }

    @Test
    void getPopularity() {
        assertEquals(popularity, artistFull.getPopularity(), "getPopularity should return the correct popularity.");
    }
}
