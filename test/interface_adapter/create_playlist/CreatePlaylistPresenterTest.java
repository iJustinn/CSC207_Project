package interface_adapter.create_playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.create_playlist.CreatePlaylistOutputData;

import static org.junit.jupiter.api.Assertions.*;

class CreatePlaylistPresenterTest {

    private CreateViewModel viewModel;
    private CreatePlaylistPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new CreateViewModel();
        presenter = new CreatePlaylistPresenter(viewModel);
    }

    @Test
    void prepareSuccessView() {
        CreatePlaylistOutputData outputData = new CreatePlaylistOutputData("Test Playlist", "2021-01-01");
        presenter.prepareSuccessView(outputData, "successfully");
        assertTrue(viewModel.isCreationSuccessful());
        assertEquals("successfully", viewModel.getCreationMessage());
    }

    @Test
    void prepareFailView() {
        presenter.prepareFailView("failure message");
        assertFalse(viewModel.isCreationSuccessful());
        assertEquals("failure message", viewModel.getCreationMessage());
    }
}
