package interface_adapter.view_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.view_song.ViewSongInputBound;
import use_case.view_song.ViewSongInputData;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewSongControllerTest {

    private ViewSongController controller;
    private ViewSongInputBound interactor;

    @BeforeEach
    void setUp() {
        interactor = mock(ViewSongInputBound.class);
        controller = new ViewSongController(interactor);
    }

    @Test
    void execute_callsInteractor() throws IOException {
        String user = "testUser";
        String playlistName = "testPlaylist";

        controller.execute(user, playlistName);

        verify(interactor, times(1)).execute(eq(user), any(ViewSongInputData.class));
    }
}
