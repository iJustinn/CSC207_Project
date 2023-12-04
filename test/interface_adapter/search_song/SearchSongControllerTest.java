package interface_adapter.search_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.search.search_song.SearchSongInputBoundary;
import use_case.search.search_song.SearchSongInputData;

import static org.mockito.Mockito.*;

class SearchSongControllerTest {
    @Mock
    private SearchSongInputBoundary interactor;
    private SearchSongController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new SearchSongController(interactor);
    }

    @Test
    void executeShouldCallInteractor() {
        String searchQuery = "Test Song";
        controller.execute(searchQuery);
        verify(interactor).execute(new SearchSongInputData(searchQuery));
    }
}
