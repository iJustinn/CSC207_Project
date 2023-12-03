package interface_adapter.add_song;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddSongPresenterTest {
    private AddSongViewModel viewModel;
    private AddSongPresenter presenter;

    @Before
    public void setUp() {
        viewModel = new AddSongViewModel();
        presenter = new AddSongPresenter(viewModel);
    }

    @Test
    public void testPrepareSuccessView() {
        String successMessage = "Song added successfully.";
        presenter.prepareSuccessView(successMessage);

        AddSongState state = viewModel.getState();
        assertEquals("The success message should match", successMessage, state.getMessage());
    }

    @Test
    public void testPrepareFailView() {
        String errorMessage = "Failed to add song.";
        presenter.prepareFailView(errorMessage);

        AddSongState state = viewModel.getState();
        assertEquals("The error message should match", errorMessage, state.getError());
    }
}
