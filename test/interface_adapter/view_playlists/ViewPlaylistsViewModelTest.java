package interface_adapter.view_playlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ViewPlaylistsViewModelTest {

    private ViewPlaylistsViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new ViewPlaylistsViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setState_notifiesListeners() {
        ViewPlaylistsState state = new ViewPlaylistsState();

        viewModel.setState(state);

        verify(mockListener, times(1)).propertyChange(any());
    }

    @Test
    void getState_returnsCorrectState() {
        ViewPlaylistsState state = new ViewPlaylistsState();
        viewModel.setState(state);

        assertEquals(state, viewModel.getState());
    }
}
