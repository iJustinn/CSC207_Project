package interface_adapter.delete_song;

import interface_adapter.delete_song.DeleteSongPresenter;
import interface_adapter.delete_song.DeleteSongState;
import interface_adapter.delete_song.DeleteSongViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.delete_song.DeleteSongOutputData;

import static org.mockito.Mockito.*;

public class DeleteSongPresenterTest {

    private DeleteSongPresenter presenter;
    private DeleteSongViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = mock(DeleteSongViewModel.class);
        presenter = new DeleteSongPresenter(viewModel);
    }

    @Test
    void prepareSuccessView_updatesViewModel() {


        verify(viewModel, times(1)).setState(any(DeleteSongState.class));
    }

    @Test
    void prepareFailView_updatesViewModel() {



        verify(viewModel, times(1)).setState(any(DeleteSongState.class));
    }
}