package interface_adapter.search_album;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchAlbumViewModel {
    private SearchAlbumState state = new SearchAlbumState();

    public SearchAlbumViewModel(SearchAlbumState searchAlbumState) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchAlbumState getState() {
        return state;
    }

    public void setState(SearchAlbumState state) {
        this.state = state;
    }
}
