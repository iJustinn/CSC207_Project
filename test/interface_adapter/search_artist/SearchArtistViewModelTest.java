package interface_adapter.search_artist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;
import static org.mockito.Mockito.*;

class SearchArtistViewModelTest {
    private SearchArtistViewModel viewModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        viewModel = new SearchArtistViewModel();
        listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);
    }

    @Test
    void stateChangeShouldNotifyListeners() {
        SearchArtistState newState = new SearchArtistState();
        newState.setSearchInput("New Artist");

        viewModel.setState(newState);
        verify(listener, times(1)).propertyChange(any());
    }
}
