package interface_adapter.search_artist;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchArtistViewModel extends ViewModel {
    public static final String TITLE_LABEL = "SEARCH ARTIST FUNCTION";
    public static final String SEARCH_BUTTON_LABEL = "Search";

    private SearchArtistState state = new SearchArtistState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SearchArtistViewModel() {
        super("search artist");
    }

    public SearchArtistState getState() {
        return state;
    }

    public void setState(SearchArtistState state) {
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
