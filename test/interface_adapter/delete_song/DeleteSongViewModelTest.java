package interface_adapter.delete_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class DeleteSongViewModelTest {

    private DeleteSongViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new DeleteSongViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setState_notifiesListener() {
        DeleteSongState state = new DeleteSongState();
        state.setDeletionSuccessful(true);

        viewModel.setState(state);

        verify(mockListener, times(1)).propertyChange(any());
    }

    @Test
    void getState_returnsCorrectState() {
        DeleteSongState state = new DeleteSongState();
        state.setDeletionSuccessful(true);
        viewModel.setState(state);

        assertEquals(state, viewModel.getState());
    }

    @Test
    void isDeletionSuccessful_returnsCorrectValue() {
        DeleteSongState state = new DeleteSongState();
        state.setDeletionSuccessful(true);
        viewModel.setState(state);

        assertTrue(viewModel.isDeletionSuccessful());
    }

    // Additional tests can be added to cover various scenarios
}