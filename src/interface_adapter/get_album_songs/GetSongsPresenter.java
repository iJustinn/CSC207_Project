package interface_adapter.get_album_songs;

import interface_adapter.ViewManagerModel;
import use_case.get_album_songs.GetAlbumSongsOutputBoundary;
import use_case.get_album_songs.GetAlbumSongsOutputData;

public class GetSongsPresenter implements GetAlbumSongsOutputBoundary {
    private final GetSongsViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public GetSongsPresenter(GetSongsViewModel viewModel,
                             ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void success(GetAlbumSongsOutputData output) {
        GetSongsState state = viewModel.getState();
        state.setSongs(output.getSongs());
        viewModel.setState(state);
        viewModel.firePropertyChanged();

        viewManagerModel.setActiveViewName(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void fail(String error) {
        // TODO: To be implemented
    }
}
