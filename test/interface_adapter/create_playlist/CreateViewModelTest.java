package interface_adapter.create_playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CreateViewModelTest {

    private CreateViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new CreateViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void testStateUpdateAndNotification() {
        CreatePlaylistState newState = new CreatePlaylistState();
        newState.setPlaylistName("New Playlist");
        newState.setCreationSuccessful(true);
        newState.setMessage("Created successfully");

        viewModel.SetState(newState);

        verify(mockListener, times(1)).propertyChange(any());
        assertTrue(viewModel.isCreationSuccessful());
        assertEquals("Created successfully", viewModel.getCreationMessage());
    }
}
