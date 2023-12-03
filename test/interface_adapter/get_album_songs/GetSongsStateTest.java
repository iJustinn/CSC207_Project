package interface_adapter.get_album_songs;

import org.junit.Test;
import entity.song.Song;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class GetSongsStateTest {

    @Test
    public void testSetAndGetSongs() {
        GetSongsState state = new GetSongsState();
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Test", new ArrayList<>(), "Album", "1"));
        state.setSongs(songs);

        assertEquals(songs, state.getSongs());
    }

    @Test
    public void testSetAndGetSearchId() {
        GetSongsState state = new GetSongsState();
        String searchId = "testId";
        state.setSearchId(searchId);
        assertEquals(searchId, state.getSearchId());
    }
}
