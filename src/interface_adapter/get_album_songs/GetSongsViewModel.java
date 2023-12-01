package interface_adapter.get_album_songs;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class GetSongsViewModel extends ViewModel {

    public static final String FAVOURITE_ALBUM_BUTTON_LABEL = "Favourite";
    public static final String ADD_SONG_BUTTON_LABEL = "Add song";


    private GetSongsState state = new GetSongsState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GetSongsViewModel() {
        super("get songs");
    }

    public GetSongsState getState() {
        return state;
    }

    public void setState(GetSongsState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
