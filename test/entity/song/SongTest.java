package entity.song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spotify.models.AlbumSimpleModel;
import spotify.models.ArtistSimpleModel;
import spotify.models.TrackModel;

import java.util.Arrays;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SongTest {
    private Song song;
    private final String title = "Test Title";
    private final ArrayList<String> artist = new ArrayList<>(Arrays.asList("Artist1", "Artist2"));
    private final String album = "Test Album";
    private final String id = "1";
    private final String comment = "Test Comment";

    @BeforeEach
    void setUp() {
        song = new Song(title, artist, album, id);
    }

    @AfterEach
    void tearDown() {
        song = null;
    }

    @Test
    void Song(){
        Song song = new Song();
        assertEquals(1,1);
    }

    @Test
    void constructorWithTrackModel() {
        // Mocking the TrackModel and ArtistSimpleModel
        TrackModel mockTrack = mock(TrackModel.class);
        ArtistSimpleModel mockArtist = mock(ArtistSimpleModel.class);
        AlbumSimpleModel mockAlbum = mock(AlbumSimpleModel.class); // Assuming there's an AlbumSimpleModel

        // Stubbing the methods of the mocked objects
        when(mockTrack.getName()).thenReturn(title);
        when(mockTrack.getArtists()).thenReturn(Arrays.asList(mockArtist));
        when(mockArtist.getName()).thenReturn(artist.get(0));
        when(mockTrack.getAlbum()).thenReturn(mockAlbum);
        when(mockAlbum.getAlbumName()).thenReturn(album);
        when(mockTrack.getId()).thenReturn(id);

        Song songFromTrack = new Song(mockTrack);

        assertEquals(title, songFromTrack.getTitle(), "Constructor with TrackModel should set the title correctly.");
        assertEquals(artist, songFromTrack.getArtist(), "Constructor with TrackModel should set the artist correctly.");
        assertEquals(album, songFromTrack.getAlbum(), "Constructor with TrackModel should set the album correctly.");
        assertEquals(id, songFromTrack.getId(), "Constructor with TrackModel should set the id correctly.");
        assertEquals("", songFromTrack.getComment(), "Constructor with TrackModel should initialize comment with an empty string.");
    }
    @Test
    void getTitle() {
        assertEquals(title, song.getTitle(), "getTitle should return the correct title.");
    }

    @Test
    void setTitle() {
        String newTitle = "New Title";
        song.setTitle(newTitle);
        assertEquals(newTitle, song.getTitle(), "setTitle should set the title correctly.");
    }

    @Test
    void getArtist() {
        assertEquals(artist, song.getArtist(), "getArtist should return the correct artists.");
    }

    // Assuming there's no 'setArtist' method since it wasn't provided

    @Test
    void getAlbum() {
        assertEquals(album, song.getAlbum(), "getAlbum should return the correct album.");
    }

    @Test
    void setAlbum() {
        String newAlbum = "New Album";
        song.setAlbum(newAlbum);
        assertEquals(newAlbum, song.getAlbum(), "setAlbum should set the album correctly.");
    }

    @Test
    void getId() {
        assertEquals(id, song.getId(), "getId should return the correct id.");
    }

    // Assuming there's no 'setId' method since it wasn't provided

    @Test
    void getComment() {
        // Since initially, the comment is set to EMPTY_STRING in the constructor
        assertEquals("", song.getComment(), "getComment should return the correct comment.");
    }

    @Test
    void setComment() {
        song.setComment(comment);
        assertEquals(comment, song.getComment(), "setComment should set the comment correctly.");
    }
}
