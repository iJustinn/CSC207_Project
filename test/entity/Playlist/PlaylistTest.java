package entity.Playlist;

import entity.song.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    private Playlist playlist;
    private final String name = "Test Playlist";
    private final int numberOfSongs = 3;
    private final Date date = new Date();
    private final HashMap<String, Song> songs = new HashMap<>();
    private final Song song = new Song("Test Song", new ArrayList<>(), "Test Album", "1");

    @BeforeEach
    void setUp() {
        songs.put(song.getId(), song);
        playlist = new Playlist(name, numberOfSongs, date, songs);
    }

    @AfterEach
    void tearDown() {
        playlist = null;
    }

    @Test
    void testJacksonConstructor() {
        Playlist emptyPlaylist = new Playlist();
        assertNotNull(emptyPlaylist);
        assertNull(emptyPlaylist.getName());
        assertNull(emptyPlaylist.getDate());
        assertEquals(emptyPlaylist.getSongs(), new HashMap<>());
    }

    @Test
    void getName() {
        assertEquals(name, playlist.getName());
    }

    @Test
    void setName() {
        String newName = "New Playlist";
        playlist.setName(newName);
        assertEquals(newName, playlist.getName());
    }

    @Test
    void getNumberOfSongs() {
        assertEquals(numberOfSongs, playlist.getNumberOfSongs());
    }

    @Test
    void setNumberOfSongs() {
        int newNumberOfSongs = 5;
        playlist.setNumberOfSongs(newNumberOfSongs);
        assertEquals(newNumberOfSongs, playlist.getNumberOfSongs());
    }

    @Test
    void getDate() {
        assertEquals(date, playlist.getDate());
    }

    @Test
    void setDate() {
        Date newDate = new Date();
        playlist.setDate(newDate);
        assertEquals(newDate, playlist.getDate());
    }

    @Test
    void getSongs() {
        assertEquals(songs, playlist.getSongs());
        assertTrue(playlist.getSongs().containsKey(song.getId()));
        assertEquals(song, playlist.getSongs().get(song.getId()));
    }

    @Test
    void setSongs() {
        HashMap<String, Song> newSongs = new HashMap<>();
        Song newSong = new Song("New Song", new ArrayList<>(), "New Album", "2");
        newSongs.put(newSong.getId(), newSong);
        playlist.setSongs(newSongs);
        assertEquals(newSongs, playlist.getSongs());
        assertTrue(playlist.getSongs().containsKey(newSong.getId()));
        assertEquals(newSong, playlist.getSongs().get(newSong.getId()));
    }


    @Test
    void getSong() {
        playlist.setSongs(songs);
        assertEquals(song, playlist.getSongs().get(song.getId()));
    }
}
