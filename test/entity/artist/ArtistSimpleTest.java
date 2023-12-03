package entity.artist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spotify.models.ArtistSimpleModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class ArtistSimpleTest {
    private ArtistSimple artistSimple;
    private final String id = "1";
    private final String name = "Artist Name";

    @BeforeEach
    void setUp() {
        artistSimple = new ArtistSimple(id, name);
    }

    @AfterEach
    void tearDown() {
        artistSimple = null;
    }

    @Test
    void testConstructor() {
        assertEquals(id, artistSimple.getId(), "Constructor should set ID correctly");
        assertEquals(name, artistSimple.getName(), "Constructor should set name correctly");
    }

    @Test
    void getId() {
        assertEquals(id, artistSimple.getId(), "getId should return the correct ID.");
    }

    @Test
    void getName() {
        assertEquals(name, artistSimple.getName(), "getName should return the correct name.");
    }

    @Test
    void constructorWithArtistSimpleModel() {
        // Create a mock ArtistSimpleModel
        ArtistSimpleModel mockArtistModel = mock(ArtistSimpleModel.class);

        // Define behavior for the mock's methods
        when(mockArtistModel.getId()).thenReturn(id);
        when(mockArtistModel.getName()).thenReturn(name);

        // Use the mock to create an instance of ArtistSimple
        ArtistSimple artistFromModel = new ArtistSimple(mockArtistModel);

        // Verify that the fields are set correctly
        assertEquals(id, artistFromModel.getId(), "Constructor with ArtistSimpleModel should set ID correctly");
        assertEquals(name, artistFromModel.getName(), "Constructor with ArtistSimpleModel should set name correctly");
    }
}
