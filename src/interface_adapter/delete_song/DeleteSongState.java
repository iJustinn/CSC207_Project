package interface_adapter.delete_song;

public class DeleteSongState {
    private boolean deletionSuccessful;


    public boolean isDeletionSuccessful() {
        return deletionSuccessful;
    }

    public void setDeletionSuccessful(boolean deletionSuccessful) {
        this.deletionSuccessful = deletionSuccessful;
    }
}
