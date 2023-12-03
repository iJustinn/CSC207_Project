package interface_adapter.delete_playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.delete_playlist.DeletePlaylistOutputData;
import static org.junit.jupiter.api.Assertions.*;

class DeletePlaylistPresenterTest {

    private DeletePlaylistViewModel viewModel;
    private DeletePlaylistPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new DeletePlaylistViewModel();
        presenter = new DeletePlaylistPresenter(viewModel);
    }

    @Test
    void prepareSuccessView() {
        DeletePlaylistOutputData outputData = new DeletePlaylistOutputData(true, "Deleted successfully");
        presenter.prepareSuccessView(outputData);
        assertTrue(viewModel.getState().isDeletionSuccessful());
        assertEquals("Deleted successfully", viewModel.getState().getDeletionMessage());
    }

    @Test
    void prepareFailView() {
        DeletePlaylistOutputData outputData = new DeletePlaylistOutputData(false, "Deletion failed");
        presenter.prepareFailView(outputData);
        assertFalse(viewModel.getState().isDeletionSuccessful());
        assertEquals("Deletion failed", viewModel.getState().getDeletionMessage());
    }
}
