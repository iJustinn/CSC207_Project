package interface_adapter.delete_playlist;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeletePlaylistViewModel extends ViewModel {

    public static final String DELETE_BUTTON_LABEL = "Delete";
    public static final String TITLE_LABEL = "Delete Playlist View";

    private DeletePlaylistState state = new DeletePlaylistState();

    public DeletePlaylistViewModel() {
        super("delete playlist");
    }

    public void setState(DeletePlaylistState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the DeletePlaylist Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DeletePlaylistState getState() {
        return state;
    }

    public void setDeletionSuccessful(boolean success) {
        state.setDeletionSuccessful(success);
        support.firePropertyChange("deletionStatus", !success, success);
    }

    public void setDeletionMessage(String message) {
        state.setDeletionMessage(message);
        support.firePropertyChange("deletionMessage", null, message);
    }
}
