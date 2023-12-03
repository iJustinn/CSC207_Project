package view;

import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.UpdateCommentView;

import javax.swing.*;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UpdateCommentViewTest {

    @Mock
    private UpdateCommentViewModel mockViewModel;
    @Mock
    private UpdateCommentController mockController;

    private UpdateCommentView updateCommentView;
    private JTextArea commentTextArea;
    private JButton updateButton;
    private JButton cancelButton;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateCommentView = new UpdateCommentView(mockViewModel, mockController);

        commentTextArea = (JTextArea) getField(updateCommentView, "commentTextArea");
        updateButton = (JButton) getField(updateCommentView, "updateButton");
        cancelButton = (JButton) getField(updateCommentView, "cancelButton");
    }

    @Test
    void testUpdateComment() throws IOException {
        // Set a mock comment in the text area
        commentTextArea.setText("New Comment");

        // Simulate button click
        updateButton.doClick();

        // Verify that the controller's method was called
        verify(mockController, times(1)).updateComment(anyString(), eq("New Comment"), anyString());
    }

    @Test
    void testCancelUpdate() {
        // Simulate button click
        cancelButton.doClick();

        // Verify that the text area is cleared
        assertTrue(commentTextArea.getText().isEmpty());
    }

    // Utility method to access private fields for testing
    private Object getField(Object obj, String fieldName) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
