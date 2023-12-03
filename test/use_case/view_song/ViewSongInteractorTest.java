package use_case.view_song;

import entity.song.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

class ViewSongInteractorTest {

    private ViewSongDataAccess dataAccess;
    private ViewSongOutputBound presenter;
    private ViewSongInteractor interactor;

    @BeforeEach
    void setUp() {
        dataAccess = mock(ViewSongDataAccess.class);
        presenter = mock(ViewSongOutputBound.class);
        interactor = new ViewSongInteractor(dataAccess, presenter);
    }

    @Test
    void executeWithSongs() throws IOException {
        // Mock the input data
        String user = "Alice";
        ViewSongInputData inputData = new ViewSongInputData("PlaylistName");

        // Prepare mock song data
        HashMap<String, Song> songMap = new HashMap<>();
        songMap.put("1", new Song("SongTitle1", new ArrayList<>(), "Album1", "1"));
        songMap.put("2", new Song("SongTitle2", new ArrayList<>(), "Album2", "2"));

        // Mocking the data access behavior
        when(dataAccess.getSongsByPlaylistName(user, inputData.getPlaylistName())).thenReturn(songMap);

        // Executing the interactor
        interactor.execute(user, inputData);

        // Verify that the presenter is called with the correct output data
        verify(presenter, times(1)).prepareSuccessView(any(ViewSongOutputData.class));
    }

    @Test
    void executeWithIOException() throws IOException {
        // Mock the input data
        String user = "Alice";
        ViewSongInputData inputData = new ViewSongInputData("PlaylistName");

        // Simulating IOException
        when(dataAccess.getSongsByPlaylistName(anyString(), anyString())).thenThrow(IOException.class);

        // Asserting that the IOException is thrown
        assertThrows(IOException.class, () -> interactor.execute(user, inputData));
    }
}
