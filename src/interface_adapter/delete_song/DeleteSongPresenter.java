package interface_adapter.delete_song;

import use_case.delete_song.DeleteSongOutputBoundary;
import use_case.delete_song.DeleteSongOutputData;

public class DeleteSongPresenter implements DeleteSongOutputBoundary {
    private final DeleteSongViewModel viewModel;

    public DeleteSongPresenter(DeleteSongViewModel viewModel) {
        this.viewModel = viewModel;
    }


    @Override
    public void prepareSuccessView(DeleteSongOutputData outputData) {
        DeleteSongState state = viewModel.getState();
        state.setDeletionSuccessful(outputData.isSuccess());
        this.viewModel.setState(state);
        viewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(DeleteSongOutputData outputData) {
        DeleteSongState state = viewModel.getState();
        state.setDeletionSuccessful(outputData.isSuccess());
        this.viewModel.setState(state);
        viewModel.firePropertyChanged();

    }
}
