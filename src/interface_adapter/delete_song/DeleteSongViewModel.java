package interface_adapter.delete_song;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteSongViewModel extends ViewModel {
    private DeleteSongState state = new DeleteSongState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteSongViewModel(){
        super("DeleteView");
    }

    public void setState(DeleteSongState state) {
        this.state = state;
        firePropertyChanged(); // Assuming ViewModel has a method to notify observers
    }

    public DeleteSongState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public boolean isDeletionSuccessful() {
        return state.isDeletionSuccessful();
    }
}
