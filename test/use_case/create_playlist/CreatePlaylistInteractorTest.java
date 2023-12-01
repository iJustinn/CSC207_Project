package use_case.create_playlist;

import data_access.UserDatabaseDataAccessObject;
import entity.Playlist.Playlist;
import entity.Playlist.PlaylistFactory;
import entity.User.UserDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import use_case.create_playlist.CreatePlaylistInteractor;
import use_case.create_playlist.CreatePlaylistOutputBoundary;

import static org.junit.Assert.*;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class CreatePlaylistInteractorTest {
    private UserDatabaseDataAccessObject dataAccess;
    private CreatePlaylistInteractor interactor;
    private PlaylistFactory playlistFactory;
    private CreatePlaylistOutputBoundary presenter;

    @Before
    public void setUp() {
        playlistFactory = new PlaylistFactory(); // Assuming PlaylistFactory has a no-argument constructor
        dataAccess = new UserDatabaseDataAccessObject("src/database");
        presenter = mock(CreatePlaylistOutputBoundary.class);
        interactor = new CreatePlaylistInteractor(dataAccess, presenter, playlistFactory);
    }

    @Test
    public void testCreatePlaylistSuccessful() throws IOException {
        String playlistName = "Unique Playlist";

        CreatePlaylistInputData inputData = new CreatePlaylistInputData(playlistName);
        interactor.execute(inputData);

        assertTrue(dataAccess.checkPlaylistExist("Alice", playlistName));
        verify(presenter).prepareSuccessView(any(CreatePlaylistOutputData.class), eq("successfully"));
    }

    @Test
    public void testCreatePlaylistFailure() throws IOException {
        String playlistName = "Existing Playlist";
        dataAccess.createPlaylist("Alice", playlistFactory.create(playlistName));

        CreatePlaylistInputData inputData = new CreatePlaylistInputData(playlistName);
        interactor.execute(inputData);

        verify(presenter).prepareFailView("This playlist already exists.");
    }

    @Test(expected = IOException.class)
    public void testCreatePlaylistIOException() throws IOException {
        CreatePlaylistDataAccessInterface mockDataAccess = mock(CreatePlaylistDataAccessInterface.class);
        when(mockDataAccess.createPlaylist(anyString(), any(Playlist.class))).thenThrow(new IOException("Failed to access database"));

        CreatePlaylistInteractor interactorWithMock = new CreatePlaylistInteractor(mockDataAccess, mock(CreatePlaylistOutputBoundary.class), new PlaylistFactory());
        CreatePlaylistInputData inputData = new CreatePlaylistInputData("Test Playlist");

        interactorWithMock.execute(inputData);
    }

    @After
    public void tearDown() throws IOException {
        // Reset the JSON file to its original state
        UserDatabase cleanState = dataAccess.loadUserDatabase("TB");
        dataAccess.saveUserDatabase("Alice", cleanState);
    }
}
