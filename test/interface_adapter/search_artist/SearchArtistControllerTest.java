package interface_adapter.search_artist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.search.search_artist.SearchArtistInputBoundary;
import use_case.search.search_artist.SearchArtistInputData;

import static org.mockito.Mockito.*;

class SearchArtistControllerTest {
    @Mock
    private SearchArtistInputBoundary interactor;

    private SearchArtistController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new SearchArtistController(interactor);
    }

    @Test
    void executeShouldCallInteractor() {
        String searchQuery = "Artist Name";
        controller.execute(searchQuery);
        verify(interactor, times(1)).execute(any(SearchArtistInputData.class));
    }
}
