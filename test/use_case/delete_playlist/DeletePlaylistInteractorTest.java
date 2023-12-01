package use_case.delete_playlist;

import data_access.UserDatabaseDataAccessObject;
import entity.User.UserDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DeletePlaylistInteractorTest {

    private UserDatabaseDataAccessObject dataAccess;
    private DeletePlaylistOutputBoundary presenter;
    private DeletePlaylistInteractor interactor;

    @BeforeEach
    void setUp() {
        // Assuming UserDatabaseDataAccessObject is the actual implementation
        dataAccess = new UserDatabaseDataAccessObject("src/database");
        presenter = mock(DeletePlaylistOutputBoundary.class);
        interactor = new DeletePlaylistInteractor(dataAccess, presenter);
    }

    @Test
    void executeWithSuccessfulDeletion() throws IOException {
        String playlistId = "love story";
        // Ensure the playlist exists before test execution
        assertTrue(dataAccess.checkPlaylistExist("Alice", playlistId));

        DeletePlaylistInputData inputData = new DeletePlaylistInputData(playlistId);
        interactor.execute(inputData);

        assertFalse(dataAccess.checkPlaylistExist("Alice", playlistId));
        verify(presenter).prepareSuccessView(any(DeletePlaylistOutputData.class));
    }

    @Test
    void executeWithFailedDeletion() throws IOException {
        String playlistId = "NonExisting Playlist";
        // Ensure the playlist does not exist before test execution
        assertFalse(dataAccess.checkPlaylistExist("Alice", playlistId));

        DeletePlaylistInputData inputData = new DeletePlaylistInputData(playlistId);
        interactor.execute(inputData);

        verify(presenter).prepareFailView(any(DeletePlaylistOutputData.class));
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Reset the JSON file to its original state
        UserDatabase cleanState = dataAccess.loadUserDatabase("TB");
        dataAccess.saveUserDatabase("Alice", cleanState);
    }
}
