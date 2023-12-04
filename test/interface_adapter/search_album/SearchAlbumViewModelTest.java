package interface_adapter.search_album;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SearchAlbumViewModelTest {
    private SearchAlbumViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new SearchAlbumViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void testPropertyChangeNotification() {
        SearchAlbumState newState = new SearchAlbumState();
        viewModel.setState(newState);

        verify(mockListener).propertyChange(any());
    }

    @Test
    void testGetAndSetState() {
        SearchAlbumState state = new SearchAlbumState();
        state.setSearchInput("Test Input");
        viewModel.setState(state);

        assertEquals("Test Input", viewModel.getState().getSearchInput());
    }
}
