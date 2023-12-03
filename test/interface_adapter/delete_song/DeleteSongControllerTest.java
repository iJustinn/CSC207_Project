package interface_adapter.delete_song;

import interface_adapter.delete_song.DeleteSongController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.delete_song.DeleteSongInputBoundary;
import use_case.delete_song.DeleteSongInputData;

import static org.mockito.Mockito.*;

public class DeleteSongControllerTest {

    @Mock
    private DeleteSongInputBoundary mockInteractor;

    private DeleteSongController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new DeleteSongController(mockInteractor);
    }

    @Test
    void execute_callsInteractor() {
        String songId = "song1";
        String playlistId = "playlist1";
        controller.execute(songId, playlistId);

        verify(mockInteractor, times(1)).execute(any(DeleteSongInputData.class));
    }

    // Additional test cases as needed...
}
