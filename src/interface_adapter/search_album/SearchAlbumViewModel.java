package interface_adapter.search_album;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchAlbumViewModel extends ViewModel {
    public static final String TITLE_LABEL = "SEARCH ALBUM FUNCTION";

    public static final String SEARCH_BUTTON_LABEL = "Search";

    private SearchAlbumState state = new SearchAlbumState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SearchAlbumViewModel() {
        super("search album");
    }

    public SearchAlbumState getState() {
        return state;
    }

    public void setState(SearchAlbumState state) {
        this.state = state;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}