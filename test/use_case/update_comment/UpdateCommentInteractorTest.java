package use_case.update_comment;

import data_access.UserDatabaseDataAccessObject;
import entity.User.UserDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UpdateCommentInteractorTest {

    private UserDatabaseDataAccessObject dataAccess;
    private UpdateCommentOutputBoundary presenter;
    private UpdateCommentInteractor interactor;

    @BeforeEach
    void setUp() {
        dataAccess = new UserDatabaseDataAccessObject("src/database");
        presenter = mock(UpdateCommentOutputBoundary.class);
        interactor = new UpdateCommentInteractor(dataAccess, presenter);
    }

    @Test
    void executeWithSuccessfulCommentUpdate() throws IOException {
        /**
         * The reason why we don't test fail since it can only be success otherwise I cannot see the song
         * and playlist anyway.
         */
        String songId = "2";
        String playlistName = "love story";
        String comment = "New Comment";

        UpdateCommentInputData inputData = new UpdateCommentInputData(songId, comment, playlistName);
        interactor.execute(inputData);

        // Verify the presenter was called with success message
        verify(presenter).presentSuccess("Comment updated successfully.");

        // Optionally, verify that the comment was updated in the database
        String updatedComment = dataAccess.getSongsByPlaylistName("Alice", playlistName).get(songId).getComment();
        assertEquals(comment, updatedComment);
    }

    @Test
    void executeWithIOException() throws IOException {
        UpdateCommentDataAccessInterface mockDataAccess = mock(UpdateCommentDataAccessInterface.class);

        // Use doThrow() for methods that return void
        doThrow(new IOException("IO Exception occurred"))
                .when(mockDataAccess).addComment(anyString(), anyString(), anyString(), anyString());

        UpdateCommentInteractor interactorWithMock = new UpdateCommentInteractor(mockDataAccess, presenter);
        UpdateCommentInputData inputData = new UpdateCommentInputData("2", "love story", "New Comment");

        interactorWithMock.execute(inputData);

        // Verify that presenter is called with the failure message
        verify(presenter).presentFailure(startsWith("Failed to update comment: IO Exception occurred"));
    }
    
    @AfterEach
    public void tearDown() throws IOException {
        // Reset the JSON file to its original state
        UserDatabase cleanState = dataAccess.loadUserDatabase("TB");
        dataAccess.saveUserDatabase("Alice", cleanState);
    }
}
