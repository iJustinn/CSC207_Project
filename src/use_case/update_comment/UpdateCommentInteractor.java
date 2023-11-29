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
    public void execute(UpdateCommentInputData updateCommentInputData) throws IOException {
        addCommentDataAccessObject.addComment("Alice", updateCommentInputData.getId(),
                updateCommentInputData.getComment(), updateCommentInputData.getPlaylist());

    }
}
