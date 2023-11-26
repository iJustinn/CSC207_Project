package interface_adapter.view_playlists;

import use_case.view_playlists.ViewPlaylistsOutputBoundary;
import use_case.view_playlists.ViewPlaylistsOutputData;

public class ViewPlaylistsPresenter implements ViewPlaylistsOutputBoundary {

    private final ViewPlaylistsViewModel viewModel;

    public ViewPlaylistsPresenter(ViewPlaylistsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(ViewPlaylistsOutputData playlists) {
        ViewPlaylistsState state = new ViewPlaylistsState();
        state.setPlaylists(playlists.getPlaylists());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }
}
