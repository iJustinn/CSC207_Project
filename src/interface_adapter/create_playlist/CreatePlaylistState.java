package interface_adapter.create_playlist;

public class CreatePlaylistState {
    private final boolean isSuccess;
    private final String message;

    public CreatePlaylistState(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    // Getters
    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
