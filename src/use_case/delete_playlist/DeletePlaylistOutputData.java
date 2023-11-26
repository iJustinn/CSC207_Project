package use_case.delete_playlist;

public class DeletePlaylistOutputData {
    private final boolean success;
    private final String message;

    public DeletePlaylistOutputData(boolean success, String message) {
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
