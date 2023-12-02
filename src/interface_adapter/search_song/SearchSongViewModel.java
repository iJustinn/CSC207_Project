package interface_adapter.search_song;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchSongViewModel extends ViewModel {
    public static final String TITLE_LABEL = "SEARCH SONG FUNCTION";
    public static final String SEARCH_BUTTON_LABEL = "Search";

    private SearchSongState state = new SearchSongState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SearchSongViewModel() {
        super("search song");
    }

    public SearchSongState getState() {
        return state;
    }

    public void setState(SearchSongState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
