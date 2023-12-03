import interface_adapter.add_song.AddSongPresenter;
import interface_adapter.add_song.AddSongState;
import interface_adapter.add_song.AddSongViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AddSongPresenterTest {

    @Mock
    private AddSongViewModel mockViewModel;

    private AddSongPresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new AddSongPresenter(mockViewModel);
    }

    @Test
    void prepareSuccessView_updatesViewModel() {
        presenter.prepareSuccessView("Success message");

        verify(mockViewModel, times(1)).setState(any(AddSongState.class));
        verify(mockViewModel, times(1)).firePropertyChanged();
    }

    @Test
    void prepareFailView_updatesViewModel() {
        presenter.prepareFailView("Error message");

        verify(mockViewModel, times(1)).setState(any(AddSongState.class));
        verify(mockViewModel, times(1)).firePropertyChanged();
    }

    // Add more test cases as needed...
}
