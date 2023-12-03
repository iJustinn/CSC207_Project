package interface_adapter.delete_song;

import interface_adapter.delete_song.DeleteSongState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteSongStateTest {

    @Test
    void setAndGetDeletionSuccessful() {
        DeleteSongState state = new DeleteSongState();
        state.setDeletionSuccessful(true);

        assertTrue(state.isDeletionSuccessful());
    }
}