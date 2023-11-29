package interface_adapter.delete_playlist;

import use_case.delete_playlist.DeletePlaylistOutputBoundary;
import use_case.delete_playlist.DeletePlaylistOutputData;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistState;

public class DeletePlaylistPresenter implements DeletePlaylistOutputBoundary {
    private final DeletePlaylistViewModel viewModel;

    public DeletePlaylistPresenter(DeletePlaylistViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(DeletePlaylistOutputData outputData) {
        DeletePlaylistState state = new DeletePlaylistState();
        state.setDeletionSuccessful(true);
        state.setDeletionMessage(outputData.getMessage());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(DeletePlaylistOutputData outputData) {
        DeletePlaylistState state = new DeletePlaylistState();
        state.setDeletionSuccessful(false);
        state.setDeletionMessage(outputData.getMessage());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }
}
