package use_case.update_comment;

import entity.song.Song;

import java.io.IOException;

public interface UpdateCommentDataAccessInterface {
    public void addComment(String username, String id, String comment, String playlist) throws IOException;
}