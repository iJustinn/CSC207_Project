package interface_adapter.create_playlist;

import java.util.Date;

public class CreatePlaylistState {
    private String playlistName;
    private boolean creationSuccessful;

    private String message;

    public CreatePlaylistState() {
        resetState();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public boolean isCreationSuccessful() {
        return creationSuccessful;
    }

    public void setCreationSuccessful(boolean creationSuccessful) {
        this.creationSuccessful = creationSuccessful;
    }


    public void resetState() {
        this.playlistName = "";
        this.creationSuccessful = false;
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
