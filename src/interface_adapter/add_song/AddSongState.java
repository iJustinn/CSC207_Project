package interface_adapter.add_song;

public class AddSongState {

    private String message = "The song was successfully added.";
    private String error = "Error when adding song";

    public AddSongState() {
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
