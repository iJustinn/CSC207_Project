package use_case.delete_song;

public class DeleteSongOutputData {
    private final boolean success;
    private final String message;

    public DeleteSongOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
