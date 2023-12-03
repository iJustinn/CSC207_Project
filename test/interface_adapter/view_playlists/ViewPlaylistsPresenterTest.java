package interface_adapter.view_playlists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.view_playlists.ViewPlaylistsOutputData;
import java.util.ArrayList;
import static org.mockito.Mockito.*;

public class ViewPlaylistsPresenterTest {

    private ViewPlaylistsPresenter presenter;
    private ViewPlaylistsViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = mock(ViewPlaylistsViewModel.class);
        presenter = new ViewPlaylistsPresenter(viewModel);
    }

    @Test
    void prepareSuccessView_updatesViewModel() {
        ViewPlaylistsOutputData data = new ViewPlaylistsOutputData(new ArrayList<>());

        presenter.prepareSuccessView(data);

        verify(viewModel, times(1)).setState(any(ViewPlaylistsState.class));
    }
}
