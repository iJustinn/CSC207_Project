package interface_adapter.view_song;

import use_case.view_song.ViewSongOutputBound;
import use_case.view_song.ViewSongOutputData;

public class ViewSongPresenter implements ViewSongOutputBound {
    private final ViewSongViewModel viewModel;

    public ViewSongPresenter(ViewSongViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(ViewSongOutputData outputData) {
        ViewSongState state = new ViewSongState();
        state.setSongs(outputData.getSongs());
        viewModel.setState(state);
    }
}
