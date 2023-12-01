package use_case.view_playlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

class ViewPlaylistsInteractorTest {

    private ViewPlaylistsDataUserAccessInterface dataAccess;
    private ViewPlaylistsOutputBoundary presenter;
    private ViewPlaylistsInteractor interactor;

    @BeforeEach
    void setUp() {
        dataAccess = mock(ViewPlaylistsDataUserAccessInterface.class);
        presenter = mock(ViewPlaylistsOutputBoundary.class);
        interactor = new ViewPlaylistsInteractor(dataAccess, presenter);
    }

    @Test
    void executeSuccessfully() throws IOException {
        // Prepare test data
        String user = "Alice";
        ArrayList<String> playlists = new ArrayList<>();
        playlists.add("Playlist 1");
        playlists.add("Playlist 2");

        // Mocking the data access behavior
        when(dataAccess.viewPlaylists(user)).thenReturn(playlists);

        // Executing the interactor
        interactor.execute(user);

        // Verify that the presenter is called with the correct output data
        verify(presenter, times(1)).prepareSuccessView(any(ViewPlaylistsOutputData.class));
    }

    @Test
    void executeWithIOException() throws IOException {
        // Prepare test data
        String user = "Alice";

        // Simulate IOException
        when(dataAccess.viewPlaylists(anyString())).thenThrow(IOException.class);

        // Assert that the IOException is thrown
        assertThrows(IOException.class, () -> interactor.execute(user));
    }
}
