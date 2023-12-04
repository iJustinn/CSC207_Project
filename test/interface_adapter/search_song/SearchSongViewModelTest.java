package interface_adapter.search_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;

class SearchSongViewModelTest {
    private SearchSongViewModel viewModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        viewModel = new SearchSongViewModel();
        listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);
    }

    @Test
    void firePropertyChangedShouldNotifyListeners() {
        viewModel.firePropertyChanged();
        verify(listener).propertyChange(any());
    }
}
