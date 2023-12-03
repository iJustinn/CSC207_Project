package interface_adapter.view_playlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.view_playlists.ViewPlaylistsInputBoundary;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewPlaylistsControllerTest {

    private ViewPlaylistsController controller;
    private ViewPlaylistsInputBoundary interactor;

    @BeforeEach
    void setUp() {
        interactor = mock(ViewPlaylistsInputBoundary.class);
        controller = new ViewPlaylistsController(interactor);
    }

    @Test
    void execute_callsInteractor() throws IOException {
        controller.execute("testUser");

        verify(interactor, times(1)).execute("testUser");
    }
}
