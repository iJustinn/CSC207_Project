package interface_adapter.view_playlists;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ViewPlaylistsStateTest {

    @Test
    void getAndSetPlaylists() {
        ViewPlaylistsState state = new ViewPlaylistsState();
        ArrayList<String> playlists = new ArrayList<>();
        playlists.add("Playlist1");
        state.setPlaylists(playlists);

        assertEquals(playlists, state.getPlaylists());
    }
}
