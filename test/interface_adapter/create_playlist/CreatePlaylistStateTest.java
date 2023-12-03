package interface_adapter.create_playlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreatePlaylistStateTest {

    @Test
    void testStateManipulation() {
        CreatePlaylistState state = new CreatePlaylistState();
        state.setPlaylistName("Test Playlist");
        state.setCreationSuccessful(true);
        state.setMessage("Creation successful");

        assertEquals("Test Playlist", state.getPlaylistName());
        assertTrue(state.isCreationSuccessful());
        assertEquals("Creation successful", state.getMessage());

        // Testing reset
        state.resetState();
        assertEquals("", state.getPlaylistName());
        assertFalse(state.isCreationSuccessful());
        assertEquals("", state.getMessage());
    }
}
