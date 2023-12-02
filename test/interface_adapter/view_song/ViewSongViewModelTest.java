package interface_adapter.view_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ViewSongViewModelTest {

    private ViewSongViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new ViewSongViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setState_notifiesListeners() {
        ViewSongState state = new ViewSongState();

        viewModel.setState(state);

        verify(mockListener, times(1)).propertyChange(any());
    }

    @Test
    void getState_returnsCorrectState() {
        ViewSongState state = new ViewSongState();
        viewModel.setState(state);

        assertEquals(state, viewModel.getState());
    }
}
