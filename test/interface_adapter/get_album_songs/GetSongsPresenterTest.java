package interface_adapter.get_album_songs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import entity.song.Song;
import use_case.get_album_songs.GetAlbumSongsOutputData;
import java.util.ArrayList;
import java.util.List;

class GetSongsPresenterTest {
    private GetSongsViewModel viewModel;
    private GetSongsPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new GetSongsViewModel();
        presenter = new GetSongsPresenter(viewModel, null); // Assuming viewManagerModel is not needed for this test
    }

    @Test
    void testSuccess() {
        List<Song> songs = new ArrayList<>();
        GetAlbumSongsOutputData outputData = new GetAlbumSongsOutputData(songs);

        presenter.success(outputData);

        GetSongsState state = viewModel.getState();
        assertEquals(songs, state.getSongs());
        // Assuming there's a method in GetSongsViewModel to check if the state update has been fired
        assertTrue(viewModel.getViewName() == "get songs");
    }

    @Test
    void testFail() {
        presenter.fail("Error occurred");

        // Assuming no changes to the state in case of failure
        GetSongsState state = viewModel.getState();
        assertTrue(state.getSongs().isEmpty());
        assertTrue(viewModel.getViewName() == "get songs");
    }
}
