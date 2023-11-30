package interface_adapter.get_album_songs;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class GetSongsViewModel extends ViewModel {

    private GetSongsState state = new GetSongsState();

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

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
