package interface_adapter.create_playlist;

import use_case.create_playlist.CreatePlaylistOutputBoundary;
import use_case.create_playlist.CreatePlaylistOutputData;

public class CreatePlaylistPresenter implements CreatePlaylistOutputBoundary {
    private CreateViewModel viewModel;


    public CreatePlaylistPresenter(CreateViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(CreatePlaylistOutputData createPlaylistOutputData, String message) {
        CreatePlaylistState state = viewModel.getState();
        state.setPlaylistName(createPlaylistOutputData.getPlaylistName());
        state.setCreationSuccessful(true);
        state.setMessage(message);
        this.viewModel.SetState(state);
        viewModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String message) {
        CreatePlaylistState state = viewModel.getState();
        state.setCreationSuccessful(false);
        state.setMessage(message);
        this.viewModel.SetState(state);
        viewModel.firePropertyChanged();
    }
}
