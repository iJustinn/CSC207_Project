package interface_adapter.view_song;

import org.junit.jupiter.api.Test;
import use_case.view_song.SongDTO;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ViewSongStateTest {

    @Test
    void getAndSetSongs() {
        ViewSongState state = new ViewSongState();
        ArrayList<SongDTO> songs = new ArrayList<>();
        songs.add(new SongDTO("Test Song", "1", new ArrayList<>(), "Test Album", "Comment"));
        state.setSongs(songs);

        assertEquals(songs, state.getSongs());
    }
}
