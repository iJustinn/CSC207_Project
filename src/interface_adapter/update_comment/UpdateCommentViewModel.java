package interface_adapter.update_comment;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UpdateCommentViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private UpdateCommentState state = new UpdateCommentState();

    public UpdateCommentViewModel(){super("Update");}

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public UpdateCommentState getState() {
        return state;
    }

    public void SetState(UpdateCommentState state){
        this.state = state;
    }

    public void setCommentUpdateStatus(String status) {
        state.setCommentUpdated(true);
        support.firePropertyChange("commentUpdateStatus", null, status);
    }
}
