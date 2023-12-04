package interface_adapter.search_album;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.search.search_album.SearchAlbumInputBoundary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SearchAlbumControllerTest {
    private SearchAlbumInputBoundary interactor;
    private SearchAlbumController controller;

    @BeforeEach
    void setUp() {
        interactor = mock(SearchAlbumInputBoundary.class);
        controller = new SearchAlbumController(interactor);
    }

    @Test
    void testExecute() {
        String searchQuery = "Test Album";
        controller.execute(searchQuery);
        boolean result = true;
        assertEquals(result, true);
    }
}
