package interface_adapter.delete_playlist;

public class DeletePlaylistState {
    private boolean deletionSuccessful;
    private String deletionMessage;

    // Getters and Setters
    public boolean isDeletionSuccessful() {
        return deletionSuccessful;
    }

    public void setDeletionSuccessful(boolean deletionSuccessful) {
        this.deletionSuccessful = deletionSuccessful;
    }

    public String getDeletionMessage() {
        return deletionMessage;
    }

    public void setDeletionMessage(String deletionMessage) {
        this.deletionMessage = deletionMessage;
    }
}
