package use_case.delete_playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.mockito.Mockito.*;

class DeletePlaylistInteractorTest {

    private DeletePlaylistDataAccessInterface dataAccess;
    private DeletePlaylistOutputBoundary presenter;
    private DeletePlaylistInteractor interactor;

    @BeforeEach
    void setUp() {
        dataAccess = mock(DeletePlaylistDataAccessInterface.class);
        presenter = mock(DeletePlaylistOutputBoundary.class);
        interactor = new DeletePlaylistInteractor(dataAccess, presenter);
    }

    @Test
    void executeWithSuccessfulDeletion() throws IOException {
        DeletePlaylistInputData inputData = new DeletePlaylistInputData("Test Playlist ID");
        when(dataAccess.deleteplaylist("Alice", "Test Playlist ID")).thenReturn(true);

        interactor.execute(inputData);

        verify(dataAccess).deleteplaylist("Alice", "Test Playlist ID");
        verify(presenter).prepareSuccessView(any(DeletePlaylistOutputData.class));
    }

    @Test
    void executeWithFailedDeletion() throws IOException {
        DeletePlaylistInputData inputData = new DeletePlaylistInputData("Test Playlist ID");
        when(dataAccess.deleteplaylist("Alice", "Test Playlist ID")).thenReturn(false);

        interactor.execute(inputData);

        verify(dataAccess).deleteplaylist("Alice", "Test Playlist ID");
        verify(presenter).prepareFailView(any(DeletePlaylistOutputData.class));
    }
}
