package view;

import interface_adapter.get_album_songs.GetSongsController;
import interface_adapter.get_album_songs.GetSongsViewModel;
import interface_adapter.search_album.SearchAlbumController;
import interface_adapter.search_album.SearchAlbumViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class SearchAlbumViewTest {

    @Mock
    private SearchAlbumController mockSearchAlbumController;
    @Mock
    private SearchAlbumViewModel mockSearchAlbumViewModel;
    @Mock
    private GetSongsController mockGetSongsController;
    @Mock
    private GetSongsViewModel mockGetSongsViewModel;

    private SearchAlbumView searchAlbumView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        searchAlbumView = new SearchAlbumView(mockSearchAlbumController, mockSearchAlbumViewModel, mockGetSongsController, mockGetSongsViewModel);
    }

    @Test
    void testSearchButtonClicked() {
        // Setup the test environment
        String testQuery = "test";
        searchAlbumView.searchField.setText(testQuery);

        // Simulate button click
        searchAlbumView.searchButton.doClick();

        // Verify that searchAlbumController.execute is called with the right argument
        verify(mockSearchAlbumController).execute(testQuery);
    }

    @Test
    void testPropertyChangeEvent() {
        // Simulate a property change event
        when(mockSearchAlbumViewModel.getState().getAlbums()).thenReturn(new ArrayList<>());
        searchAlbumView.propertyChange(new PropertyChangeEvent(this, "albums", null, new ArrayList<>()));

        // Verify that list model is updated
        // This could be checking the size of the model or similar properties
        assertEquals(0, searchAlbumView.listModel.getSize());
    }


}
