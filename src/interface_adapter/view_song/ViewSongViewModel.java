package interface_adapter.view_song;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewSongViewModel {
    private ViewSongState state = new ViewSongState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setState(ViewSongState state) {
        this.state = state;
        firePropertyChanged();
    }

    public ViewSongState getState() {
        return state;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
