package use_case.add_comment;

import entity.Song.Song;

public class AddCommentInputData {
    private final Song song;
    //The comment we are adding
    private final String comment;


    public AddCommentInputData(Song song, String comment) {
        this.song = song;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public Song getSong() {
        return song;
    }
}
