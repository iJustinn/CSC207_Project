package use_case.add_song;

import entity.song.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

class AddSongInteractorTest {

    private AddSongUserDataAccessInterface dataAccess;
    private AddSongOutputBoundary presenter;
    private AddSongInteractor interactor;

    @BeforeEach
    void setUp() {
        dataAccess = mock(AddSongUserDataAccessInterface.class);
        presenter = mock(AddSongOutputBoundary.class);
        interactor = new AddSongInteractor(dataAccess, presenter);
    }

    @Test
    void executeWithNonExistingPlaylist() throws IOException {
        Song newSong = new Song("New Song", new ArrayList<>(), "New Album", "1");
        AddSongInputData inputData = new AddSongInputData("NonExistingPlaylist", newSong);
        when(dataAccess.checkPlaylistExist("our_username", "NonExistingPlaylist")).thenReturn(false);

        interactor.execute(inputData);

        verify(presenter).prepareFailView("This playlist does not exist.");
        verify(dataAccess, never()).addSongToPlaylist(anyString(), anyString(), any(Song.class));
    }

    @Test
    void executeWithExistingSong() throws IOException {
        Song existingSong = new Song("Existing Song", new ArrayList<>(), "Existing Album", "1");
        AddSongInputData inputData = new AddSongInputData("ExistingPlaylist", existingSong);
        when(dataAccess.checkPlaylistExist("our_username", "ExistingPlaylist")).thenReturn(true);
        when(dataAccess.checkSongExist("our_username", "ExistingPlaylist", existingSong)).thenReturn(true);

        interactor.execute(inputData);

        verify(presenter).prepareFailView("This song is already in the playlist.");
        verify(dataAccess, never()).addSongToPlaylist(anyString(), anyString(), any(Song.class));
    }

    @Test
    void executeWithNewSong() throws IOException {
        Song newSong = new Song("New Song", new ArrayList<>(), "New Album", "2");
        AddSongInputData inputData = new AddSongInputData("ExistingPlaylist", newSong);
        when(dataAccess.checkPlaylistExist("our_username", "ExistingPlaylist")).thenReturn(true);
        when(dataAccess.checkSongExist("our_username", "ExistingPlaylist", newSong)).thenReturn(false);

        interactor.execute(inputData);

        verify(dataAccess).addSongToPlaylist("our_username", "ExistingPlaylist", newSong);
        verify(presenter).prepareSuccessView("The song was successfully added.");
    }
}
