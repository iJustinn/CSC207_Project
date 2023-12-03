package interface_adapter.add_song;

import interface_adapter.add_song.AddSongState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddSongStateTest {

    @Test
    void setMessage_getsCorrectMessage() {
        AddSongState state = new AddSongState();
        state.setMessage("Success");

        assertEquals("Success", state.getMessage());
    }

    @Test
    void setError_getsCorrectError() {
        AddSongState state = new AddSongState();
        state.setError("Error");

        assertEquals("Error", state.getError());
    }

    // Add more test cases as needed...
}
