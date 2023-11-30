package interface_adapter.view_playlists;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ViewPlaylistsViewModel extends ViewModel {
    private ViewPlaylistsState state = new ViewPlaylistsState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ViewPlaylistsViewModel() {
        super("ViewPlaylist");
    }

    public void setState(ViewPlaylistsState state) {
        this.state = state;
    }

    public ViewPlaylistsState getState() {
        return state;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
