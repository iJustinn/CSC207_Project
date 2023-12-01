package interface_adapter.delete_playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DeletePlaylistViewModelTest {

    private DeletePlaylistViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new DeletePlaylistViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void testViewModelUpdates() {
        viewModel.setDeletionSuccessful(true);
        viewModel.setDeletionMessage("Deleted successfully");

        verify(mockListener, times(1)).propertyChange(any());
        assertTrue(viewModel.getState().isDeletionSuccessful());
        assertEquals("Deleted successfully", viewModel.getState().getDeletionMessage());
    }
}
