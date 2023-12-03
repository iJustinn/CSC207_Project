package entity.Playlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistFactoryTest {

    @Test
    void create() {
        PlaylistFactory factory = new PlaylistFactory();
        Playlist playlist = factory.create("new_playlist");
        assertTrue(playlist.getSongs().isEmpty());
        assertEquals(playlist.getName(), "new_playlist");
        assertEquals(playlist.getNumberOfSongs(), 0);
    }
    @Test
    void kpop_create() {
        PlaylistFactory factory = new PlaylistFactory();
        KpopPlaylist playlist = factory.kpop_create("Blackpink");
        assertFalse(playlist.getSongs().isEmpty());
        assertEquals(playlist.getName(), "KPop - Blackpink");
        assertEquals(playlist.getNumberOfSongs(), 2);

    }
}