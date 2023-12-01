package use_case.delete_song;

import data_access.UserDatabaseDataAccessObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class DeleteSongInteractorTest {
    private DeleteSongDataAccessInterface dataAccess;
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
}
