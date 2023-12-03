package use_case.view_playlists;

import data_access.UserDatabaseDataAccessObject;
import entity.Playlist.Playlist;
import entity.User.UserDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class ViewPlaylistsInteractorTest {
    private UserDatabaseDataAccessObject dataAccess;
    private ViewPlaylistsInteractor interactor;
    private ViewPlaylistsOutputBoundary presenter;

    @Before
    public void setUp() {
        dataAccess = new UserDatabaseDataAccessObject("src/database");
        presenter = mock(ViewPlaylistsOutputBoundary.class);
        interactor = new ViewPlaylistsInteractor(dataAccess, presenter);
    }

    @Test
    public void testViewPlaylists() throws IOException {
        // Prepare data
        String playlistName1 = "Playlist 1";
        String playlistName2 = "Playlist 2";
        dataAccess.createPlaylist("Alice", new Playlist(playlistName1, 0, new Date(), new HashMap<>()));
        dataAccess.createPlaylist("Alice", new Playlist(playlistName2, 0, new Date(), new HashMap<>()));

        // Execute interactor
        interactor.execute("Alice");

        // Expected playlists
        ArrayList<String> expectedPlaylists = new ArrayList<>(Arrays.asList(playlistName1, playlistName2));

        // Verify the presenter was called with the correct data
        verify(presenter).prepareSuccessView(argThat(outputData ->
                outputData.getPlaylists().equals(expectedPlaylists)
        ));
    }

    @After
    public void tearDown() throws IOException {
        // Reset the JSON file to its original state
        UserDatabase cleanState = dataAccess.loadUserDatabase("TB");
        dataAccess.saveUserDatabase("Alice", cleanState);
    }
}
