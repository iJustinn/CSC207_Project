package interface_adapter.get_album_songs;

import use_case.get_album_songs.GetAlbumSongsOutputBoundary;
import use_case.get_album_songs.GetAlbumSongsOutputData;

public class GetSongsPresenter implements GetAlbumSongsOutputBoundary {
    private final GetSongsViewModel viewModel;

    public GetSongsPresenter(GetSongsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void success(GetAlbumSongsOutputData output) {
        GetSongsState state = viewModel.getState();
        state.setSongs(output.getSongs());
        viewModel.setState(state);
    }

    @Override
    public void fail(String error) {
        // TODO: To be implemented
    }
}
