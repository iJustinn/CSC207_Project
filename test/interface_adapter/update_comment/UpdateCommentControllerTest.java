package interface_adapter.update_comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.update_comment.UpdateCommentInputBoundary;
import use_case.update_comment.UpdateCommentInputData;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class UpdateCommentControllerTest {

    private UpdateCommentController controller;
    private UpdateCommentInputBoundary interactor;

    @BeforeEach
    void setUp() {
        interactor = mock(UpdateCommentInputBoundary.class);
        controller = new UpdateCommentController(interactor);
    }

    @Test
    void updateComment_callsInteractor() throws IOException {
        controller.updateComment("songId", "New Comment", "playlistName");

        verify(interactor, times(1)).execute(any(UpdateCommentInputData.class));
    }
}
