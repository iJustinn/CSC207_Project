package interface_adapter.add_song;

public class AddSongState {

    private String message = "";
    private String error = "";

    public AddSongState(AddSongState copy){
        message = copy.message;
        error = copy.error;
    }
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
