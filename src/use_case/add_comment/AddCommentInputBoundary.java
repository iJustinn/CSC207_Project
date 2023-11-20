package use_case.add_comment;

import java.io.IOException;

public interface AddCommentInputBoundary {
    void execute(AddCommentInputData addCommentInputData) throws IOException;
}
