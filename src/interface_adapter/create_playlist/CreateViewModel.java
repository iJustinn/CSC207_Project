package interface_adapter.create_playlist;

public class CreateViewModel {
    private CreatePlaylistState state;
    // Listener or observer to notify the view
    private PlaylistViewListener viewListener;

    public void updateState(CreatePlaylistState state) {
        this.state = state;
        if (viewListener != null) {
            viewListener.onStateChanged(state);
        }
    }

    // Method to set the view listener
    public void setViewListener(PlaylistViewListener viewListener) {
        this.viewListener = viewListener;
    }

    // Interface for notifying state changes to the view
    public interface PlaylistViewListener {
        void onStateChanged(CreatePlaylistState state);
    }
}
