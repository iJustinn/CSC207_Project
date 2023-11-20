package use_case.add_comment;

import entity.Song.Song;

import java.io.IOException;

public interface AddCommentDataAccessInterface {
    public boolean addComment(String username, Song song, String comment) throws IOException;
}
