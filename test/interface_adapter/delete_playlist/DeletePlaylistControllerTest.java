package interface_adapter.delete_playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.delete_playlist.DeletePlaylistInputBoundary;
import use_case.delete_playlist.DeletePlaylistInputData;

import static org.mockito.Mockito.*;

class DeletePlaylistControllerTest {

    private DeletePlaylistInputBoundary interactor;
    private DeletePlaylistController controller;

    @BeforeEach
    void setUp() {
        interactor = mock(DeletePlaylistInputBoundary.class);
        controller = new DeletePlaylistController(interactor);
    }

    @Test
    void deletePlaylist() throws Exception {
        String playlistId = "123";
        controller.deletePlaylist(playlistId);
        verify(interactor, times(1)).execute(any(DeletePlaylistInputData.class));
    }
}
