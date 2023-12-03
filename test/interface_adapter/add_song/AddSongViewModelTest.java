package interface_adapter.add_song;

import interface_adapter.add_song.AddSongState;
import interface_adapter.add_song.AddSongViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;
import static org.mockito.Mockito.*;

public class AddSongViewModelTest {

    private AddSongViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new AddSongViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setState_firesPropertyChangeEvent() {
        AddSongState newState = new AddSongState();
        viewModel.setState(newState);

        verify(mockListener, times(1)).propertyChange(any());
    }

    // Add more test cases as needed...
}
