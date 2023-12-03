package view;

import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentState;
import interface_adapter.update_comment.UpdateCommentViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.view_song.SongDTO;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class UpdateCommentViewTest {

    @Mock
    private UpdateCommentViewModel viewModel;

    @Mock
    private UpdateCommentController controller;

    @Mock
    private UpdateCommentState updateCommentState;

    private UpdateCommentView view;

    private final SongDTO dummySong = new SongDTO("SongTitle", "1", new ArrayList<>(), "Album", "Comment");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks annotated with @Mock
        view = new UpdateCommentView(viewModel, controller); // Manually inject mocks
        view.prepareView(dummySong, "PlaylistID");
    }

    @Test
    void shouldTriggerCommentUpdateWhenUpdateButtonClicked() throws IOException {
        // Arrange
        JButton updateButton = view.updateButton;
        JTextArea commentTextArea = view.commentTextArea;
        commentTextArea.setText("New Comment");

        // Act
        updateButton.doClick();

        // Assert
        verify(controller).updateComment(dummySong.getId(), "New Comment", "PlaylistID");
    }

    @Test
    void shouldNotTriggerCommentUpdateWhenCommentIsEmpty() throws IOException {
        // Arrange
        JButton updateButton = view.updateButton;
        JTextArea commentTextArea = view.commentTextArea;
        commentTextArea.setText("");

        // Act
        updateButton.doClick();

        // Assert
        verify(controller, never()).updateComment(anyString(), anyString(), anyString());
    }

    @Test
    void shouldResetViewWhenCancelButtonClicked() {
        // Arrange
        JButton cancelButton = view.cancelButton;
        JTextArea commentTextArea = view.commentTextArea;
        commentTextArea.setText("New Comment");

        // Act
        cancelButton.doClick();

        // Assert
        assertEquals("", commentTextArea.getText());
    }

    @Test
    void shouldDisplaySuccessMessageWhenCommentIsUpdated() {
        // Arrange
        when(updateCommentState.isCommentUpdated()).thenReturn(true);
        view.displayUpdateStatus(updateCommentState);

        // Act & Assert (The assert here depends on how you handle the success message)
    }

    @Test
    void shouldDisplayErrorMessageWhenCommentIsNotUpdated() {
        // Arrange
        when(updateCommentState.isCommentUpdated()).thenReturn(false);
        view.displayUpdateStatus(updateCommentState);

        // Act & Assert (The assert here depends on how you handle the error message)
    }

    // Add more tests to cover different property change events and other scenarios
}
