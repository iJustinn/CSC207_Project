package interface_adapter.create_playlist;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateViewModel extends ViewModel {

    public final String TITLE_LABEL = "Create Playlist";

    private CreatePlaylistState state = new CreatePlaylistState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public CreateViewModel(){super("Create");}

    public CreatePlaylistState getState(){return state;}

    public void SetState(CreatePlaylistState state){this.state = state;}
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public boolean isCreationSuccessful() {
        return state.isCreationSuccessful();
    }

    public String getCreationMessage() {
        return state.getMessage();
    }
}
