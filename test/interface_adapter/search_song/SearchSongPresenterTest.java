package interface_adapter.search_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.search.search_song.SearchSongOutputData;
import entity.song.Song;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchSongPresenterTest {
    private SearchSongViewModel viewModel;
    private SearchSongPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new SearchSongViewModel();
        presenter = new SearchSongPresenter(viewModel);
    }

    @Test
    void prepareSuccessViewShouldUpdateViewModel() {
        List<Song> mockSongs = List.of(new Song());
        SearchSongOutputData outputData = new SearchSongOutputData(mockSongs);
        presenter.prepareSuccessView(outputData);
        assertEquals(viewModel.getState().getSongs(), mockSongs);
    }
}
