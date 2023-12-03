package use_case.add_song;

import data_access.UserDatabaseDataAccessObject;
import entity.Playlist.Playlist;
import entity.Playlist.PlaylistFactory;
import entity.User.UserDatabase;
import entity.song.Song;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.create_playlist.CreatePlaylistInputData;
import use_case.create_playlist.CreatePlaylistInteractor;
import use_case.create_playlist.CreatePlaylistOutputBoundary;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class AddSongInteractorTest {
    private UserDatabaseDataAccessObject dataAccess;
    private AddSongInteractor interactor;
    private AddSongOutputBoundary presenter;

    @Before
    public void setUp() {
        dataAccess = new UserDatabaseDataAccessObject("src/database");
        presenter = mock(AddSongOutputBoundary.class);
        interactor = new AddSongInteractor(dataAccess, presenter);
    }

    @Test
    public void testAddSongSuccessful() throws IOException {
        String playlistName = "Test Playlist";
        Song newSong = new Song("New Song", new ArrayList<>(Arrays.asList("New Artist")), "New Album", "1");

        dataAccess.createPlaylist("Alice", new Playlist(playlistName, 0, new Date(), new HashMap<>()));

        AddSongInputData inputData = new AddSongInputData(playlistName, newSong);
        interactor.execute(inputData);

        assertFalse(dataAccess.checkSongExist("Alice", playlistName, newSong));
        verify(presenter).prepareSuccessView("The song was successfully added.");
    }

    @Test
    public void testAddSongToNonexistentPlaylist() throws IOException {
        String playlistName = "Nonexistent Playlist";
        Song newSong = new Song("New Song", new ArrayList<>(Arrays.asList("New Artist")), "New Album", "1");

        AddSongInputData inputData = new AddSongInputData(playlistName, newSong);
        interactor.execute(inputData);

        verify(presenter).prepareFailView("This playlist does not exist.");
    }

    @Test
    public void testAddExistingSong() throws IOException {
        String playlistName = "Test Playlist";
        Song existingSong = new Song("Existing Song", new ArrayList<>(Arrays.asList("Artist")), "Album", "2");

        Playlist playlist = new Playlist(playlistName, 0, new Date(), new HashMap<>());
        playlist.getSongs().put(existingSong.getId(), existingSong);
        dataAccess.createPlaylist("Alice", playlist);

        AddSongInputData inputData = new AddSongInputData(playlistName, existingSong);
        interactor.execute(inputData);

        verify(presenter).prepareFailView("This song is already in the playlist.");
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePlaylistIOException() throws RuntimeException, IOException {
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
