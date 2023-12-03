package interface_adapter.create_playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInputData;

import java.io.IOException;

import static org.mockito.Mockito.*;

class CreatePlaylistControllerTest {

    private CreatePlaylistInputBoundary interactor;
    private CreatePlaylistController controller;

    @BeforeEach
    void setUp() {
        interactor = mock(CreatePlaylistInputBoundary.class);
        controller = new CreatePlaylistController(interactor);
    }

    @Test
    void testExecute() throws IOException {
        String playlistName = "Test Playlist";
        controller.execute(playlistName);
        verify(interactor, times(1)).execute(any(CreatePlaylistInputData.class));
    }
}
