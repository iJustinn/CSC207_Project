package interface_adapter.add_song;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddSongViewModel extends ViewModel {

    public static final String ADD = "+";

    private AddSongState state = new AddSongState();

    public AddSongViewModel() {
        super("add song");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AddSongState getState() {
        return state;
    }

    public void setState(AddSongState state) {
        this.state = state;
    }
}
