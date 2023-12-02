package interface_adapter.view_song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.view_song.ViewSongOutputData;
import java.util.ArrayList;
import static org.mockito.Mockito.*;

public class ViewSongPresenterTest {

    private ViewSongPresenter presenter;
    private ViewSongViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = mock(ViewSongViewModel.class);
        presenter = new ViewSongPresenter(viewModel);
    }

    @Test
    void prepareSuccessView_updatesViewModel() {
        ViewSongOutputData data = new ViewSongOutputData(new ArrayList<>());

        presenter.prepareSuccessView(data);

        verify(viewModel, times(1)).setState(any(ViewSongState.class));
    }
}
