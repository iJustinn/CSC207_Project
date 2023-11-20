package interface_adapter.create_playlist;

import use_case.create_playlist.CreatePlaylistOutputBoundary;
import use_case.create_playlist.CreatePlaylistOutputData;

public class CreatePlaylistPresenter implements CreatePlaylistOutputBoundary {
    private CreateViewModel viewModel;

    public CreatePlaylistPresenter(CreateViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(CreatePlaylistOutputData outputData) {
        String message = "Playlist created: " + outputData.getPlaylistName() + " at " + outputData.getCreationDateTime();
        viewModel.updateState(new CreatePlaylistState(true, message));
    }


    @Override
    public void prepareFailView(String message) {
        viewModel.updateState(new CreatePlaylistState(false, message));
    }
}
