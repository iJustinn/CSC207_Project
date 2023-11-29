package interface_adapter.update_comment;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UpdateCommentViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private UpdateCommentState state;

    public UpdateCommentViewModel() {
        this.state = new UpdateCommentState();
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public UpdateCommentState getState() {
        return state;
    }

    public void setCommentUpdateStatus(String status) {
        state.setCommentUpdated(true);
        support.firePropertyChange("commentUpdateStatus", null, status);
    }
}
