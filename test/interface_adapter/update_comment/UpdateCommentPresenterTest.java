package interface_adapter.update_comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UpdateCommentPresenterTest {

    private UpdateCommentPresenter presenter;
    private UpdateCommentViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = mock(UpdateCommentViewModel.class);
        presenter = new UpdateCommentPresenter(viewModel);
    }

    @Test
    void presentSuccess_updatesViewModel() {
        presenter.presentSuccess("Success Message");

        verify(viewModel, times(1)).setCommentUpdateStatus("Success Message", true);
    }

    @Test
    void presentFailure_updatesViewModel() {
        presenter.presentFailure("Error Message");

        verify(viewModel, times(1)).setCommentUpdateStatus("Error Message", false);
    }
}