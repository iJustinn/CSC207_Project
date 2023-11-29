package use_case.update_comment;

public class UpdateCommentInputData {
    private final String id;

    //The comment we are adding
    private final String comment;

    private final String playlist;


    public UpdateCommentInputData(String id, String comment, String playlist) {
        this.id = id;
        this.comment = comment;
        this.playlist = playlist;
    }

    public String getComment() {
        return comment;
    }

    public String getId() {
        return id;
    }

    public String getPlaylist() {
        return playlist;
    }
}
