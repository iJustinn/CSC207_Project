package interface_adapter.update_comment;

import use_case.update_comment.UpdateCommentInputBoundary;
import use_case.update_comment.UpdateCommentInputData;

import java.io.IOException;

public class UpdateCommentController {
    private final UpdateCommentInputBoundary updateCommentInputBoundary;

    public UpdateCommentController(UpdateCommentInputBoundary updateCommentInputBoundary) {
        this.updateCommentInputBoundary = updateCommentInputBoundary;
    }

    public void updateComment(String id, String comment, String playlist) throws IOException {
        UpdateCommentInputData inputData = new UpdateCommentInputData(id, comment, playlist);
        updateCommentInputBoundary.execute(inputData);
    }
}
