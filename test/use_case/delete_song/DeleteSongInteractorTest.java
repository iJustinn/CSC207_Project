package use_case.delete_song;

import data_access.UserDatabaseDataAccessObject;
import entity.User.UserDatabase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class DeleteSongInteractorTest {
    private UserDatabaseDataAccessObject dataAccess;
    private DeleteSongOutputBoundary presenter;
    private DeleteSongInteractor interactor;

    @Before
    public void setUp() throws IOException {
        dataAccess = new UserDatabaseDataAccessObject("src/database");
        presenter = mock(DeleteSongOutputBoundary.class);
        interactor = new DeleteSongInteractor(dataAccess, presenter);
    }

    @Test
    public void testDeleteSongSuccessful() {
        String playlistId = "love story";
        String songId = "2";

        DeleteSongInputData inputData = new DeleteSongInputData(songId, playlistId);
        interactor.execute(inputData);

        // Verify the presenter was called with success message
        verify(presenter).prepareSuccessView(Mockito.any(DeleteSongOutputData.class));
    }

    @Test
    public void testDeleteSongFailure(){
        String playlistId = "nonExistingPlaylist";
        String songId = "nonExistingSong";

        DeleteSongInputData inputData = new DeleteSongInputData(songId, playlistId);
        interactor.execute(inputData);

        // Verify the presenter was called with fail message
        verify(presenter).prepareFailView(Mockito.any(DeleteSongOutputData.class));
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteSongIOException() throws IOException, RuntimeException {
        // Create a mock data access object that throws an IOException
        DeleteSongDataAccessInterface mockDataAccess = mock(DeleteSongDataAccessInterface.class);
        when(mockDataAccess.deleteSongFromPlaylist(anyString(), anyString(), anyString())).thenThrow(new IOException("Failed to access database"));

        DeleteSongInteractor interactorWithMock = new DeleteSongInteractor(mockDataAccess, presenter);
        DeleteSongInputData inputData = new DeleteSongInputData("nonExistingSong", "nonExistingPlaylist");

        // Execute with the expectation of an IOException
        interactorWithMock.execute(inputData);
    }
    @After
    public void tearDown() throws IOException {
        // Reset the JSON file to its original state
        UserDatabase cleanState = dataAccess.loadUserDatabase("TB");
        dataAccess.saveUserDatabase("Alice", cleanState);
    }
}
