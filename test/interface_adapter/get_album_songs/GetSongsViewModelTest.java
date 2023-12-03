package interface_adapter.get_album_songs;

import org.junit.Before;
import org.junit.Test;
import java.beans.PropertyChangeListener;
import static org.mockito.Mockito.*;

public class GetSongsViewModelTest {
    private GetSongsViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new GetSongsViewModel();
    }

    @Test
    public void testSetAndFirePropertyChange() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);

        GetSongsState newState = new GetSongsState();
        viewModel.setState(newState);
        viewModel.firePropertyChanged();

        verify(listener).propertyChange(any());
    }
}
