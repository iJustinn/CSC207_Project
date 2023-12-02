package use_case.view_playlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class ViewPlaylistsInteractorTest {

    @Mock
    private ViewPlaylistsDataUserAccessInterface dataAccess;
    @Mock
    private ViewPlaylistsOutputBoundary presenter;

    private ViewPlaylistsInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new ViewPlaylistsInteractor(dataAccess, presenter);
    }

    @Test
    void executeWithPlaylists() throws IOException {
        String user = "Alice";
        ArrayList<String> playlists = new ArrayList<>(Arrays.asList("Playlist1", "Playlist2"));
        when(dataAccess.viewPlaylists(user)).thenReturn(playlists);

        interactor.execute(user);

        verify(presenter).prepareSuccessView(any(ViewPlaylistsOutputData.class));
        verify(dataAccess).viewPlaylists(user);
    }

    @Test
    void executeWithNoPlaylists() throws IOException {
        String user = "Alice";
        ArrayList<String> playlists = new ArrayList<>();
        when(dataAccess.viewPlaylists(user)).thenReturn(playlists);

        interactor.execute(user);

        verify(presenter).prepareSuccessView(any(ViewPlaylistsOutputData.class));
        verify(dataAccess).viewPlaylists(user);
    }

    @Test
    void executeWithIOException() throws IOException {
        String user = "Alice";
        when(dataAccess.viewPlaylists(user)).thenThrow(new IOException("Database error"));

        interactor.execute(user);

        // This part depends on how you want to handle exceptions in your presenter
        // For example, you might want to verify that a failure method is called
        // verify(presenter).prepareFailureView("Database error");

        verify(dataAccess).viewPlaylists(user);
    }
}
