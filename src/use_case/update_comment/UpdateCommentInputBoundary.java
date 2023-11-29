package use_case.update_comment;

import java.io.IOException;

public interface UpdateCommentInputBoundary {
    void execute(UpdateCommentInputData updateCommentInputData) throws IOException;
}
