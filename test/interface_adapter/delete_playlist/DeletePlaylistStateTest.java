package interface_adapter.delete_playlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeletePlaylistStateTest {

    @Test
    void testState() {
        DeletePlaylistState state = new DeletePlaylistState();
        state.setDeletionSuccessful(true);
        state.setDeletionMessage("Deleted successfully");

        assertTrue(state.isDeletionSuccessful());
        assertEquals("Deleted successfully", state.getDeletionMessage());
    }
}
