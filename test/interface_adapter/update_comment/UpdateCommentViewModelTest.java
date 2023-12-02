package interface_adapter.update_comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateCommentViewModelTest {

    private UpdateCommentViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new UpdateCommentViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setCommentUpdateStatus_notifiesListeners() {
        viewModel.setCommentUpdateStatus("Status Message", true);

        verify(mockListener, times(1)).propertyChange(any());
    }

    @Test
    void getState_returnsCorrectState() {
        UpdateCommentState state = new UpdateCommentState();
        state.setCommentUpdated(true);
        viewModel.SetState(state);

        assertEquals(state, viewModel.getState());
    }
}