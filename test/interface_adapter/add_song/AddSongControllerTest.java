import entity.song.Song;
import interface_adapter.add_song.AddSongController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.add_song.AddSongInputBoundary;
import use_case.add_song.AddSongInputData;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class AddSongControllerTest {

    @Mock
    private AddSongInputBoundary mockInteractor;

    private AddSongController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new AddSongController(mockInteractor);
    }

    @Test
    void execute_callsInteractor() throws IOException {
        Song mockSong = new Song("Title", new ArrayList<>(), "Album", "ID");
        controller.execute("Playlist", mockSong);

        verify(mockInteractor, times(1)).execute(any(AddSongInputData.class));
    }

    // Add more test cases as needed...
}
