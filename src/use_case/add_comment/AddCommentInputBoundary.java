package use_case.add_comment;

import entity.Song.Song;

import java.io.IOException;

public interface AddCommentInputBoundary {
    void execute(AddCommentInputData addCommentInputData) throws IOException;
}
