package interface_adapter.delete_song;

import interface_adapter.delete_song.DeleteSongPresenter;
import interface_adapter.delete_song.DeleteSongState;
import interface_adapter.delete_song.DeleteSongViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.delete_song.DeleteSongInputData;
import use_case.delete_song.DeleteSongOutputData;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DeleteSongPresenterTest {

    private DeleteSongPresenter presenter;
    private DeleteSongViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = new DeleteSongViewModel();
        presenter = new DeleteSongPresenter(viewModel);
    }

    @Test
    void prepareSuccessView() {
        DeleteSongOutputData deleteSongOutputData = new DeleteSongOutputData(true, "Success");
        presenter.prepareSuccessView(deleteSongOutputData);
        assertTrue(viewModel.getState().isDeletionSuccessful());
    }

    @Test
    void prepareFailView() {
        DeleteSongOutputData deleteSongOutputData = new DeleteSongOutputData(false, "Error");
        presenter.prepareFailView(deleteSongOutputData);
        assertFalse(viewModel.getState().isDeletionSuccessful());
    }
}