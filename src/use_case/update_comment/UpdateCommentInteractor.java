package use_case.update_comment;

import java.io.IOException;

public class UpdateCommentInteractor implements UpdateCommentInputBoundary {
    final UpdateCommentDataAccessInterface addCommentDataAccessObject;
    final UpdateCommentOutputBoundary addCommentPresenter;

    public UpdateCommentInteractor(UpdateCommentDataAccessInterface addCommentDataAccessObject, UpdateCommentOutputBoundary addCommentPresenter) {
        this.addCommentDataAccessObject = addCommentDataAccessObject;
        this.addCommentPresenter = addCommentPresenter;
    }

    @Override
    public void execute(UpdateCommentInputData updateCommentInputData) {
        try {
            // Attempt to add the comment
            addCommentDataAccessObject.addComment("Alice", updateCommentInputData.getId(),
                    updateCommentInputData.getComment(), updateCommentInputData.getPlaylist());

            // If the method above does not throw an exception, assume success
            addCommentPresenter.presentSuccess("Comment updated successfully.");
        } catch (IOException e) {
            // Handle any exceptions, assume failure
            addCommentPresenter.presentFailure("Failed to update comment: " + e.getMessage());
        }
    }
}
