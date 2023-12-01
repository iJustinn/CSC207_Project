package use_case.create_playlist;

import entity.Playlist.Playlist;
import entity.Playlist.PlaylistFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.mockito.Mockito.*;

class CreatePlaylistInteractorTest {

    private CreatePlaylistDataAccessInterface dataAccess;
    private CreatePlaylistOutputBoundary presenter;
    private PlaylistFactory factory;
    private CreatePlaylistInteractor interactor;

    @BeforeEach
    void setUp() {
        dataAccess = mock(CreatePlaylistDataAccessInterface.class);
        presenter = mock(CreatePlaylistOutputBoundary.class);
        factory = mock(PlaylistFactory.class);
        interactor = new CreatePlaylistInteractor(dataAccess, presenter, factory);
    }

    @Test
    void executeWithNewPlaylist() throws IOException {
        CreatePlaylistInputData inputData = new CreatePlaylistInputData("New Playlist");
        Playlist mockPlaylist = mock(Playlist.class);
        when(factory.create("New Playlist")).thenReturn(mockPlaylist);
        when(dataAccess.checkPlaylistExist("Alice", "New Playlist")).thenReturn(false);

        interactor.execute(inputData);

        verify(dataAccess).createPlaylist("Alice", mockPlaylist);
        verify(presenter).prepareSuccessView(any(CreatePlaylistOutputData.class), eq("successfully"));
    }

    @Test
    void executeWithExistingPlaylist() throws IOException {
        CreatePlaylistInputData inputData = new CreatePlaylistInputData("Existing Playlist");
        when(dataAccess.checkPlaylistExist("Alice", "Existing Playlist")).thenReturn(true);

        interactor.execute(inputData);

        verify(presenter).prepareFailView("This playlist already exists.");
        verifyNoInteractions(factory);
    }
}
