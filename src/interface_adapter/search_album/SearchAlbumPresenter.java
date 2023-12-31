package interface_adapter.search_album;

import use_case.search.search_album.SearchAlbumOutputBoundary;
import use_case.search.search_album.SearchAlbumOutputData;

public class SearchAlbumPresenter implements SearchAlbumOutputBoundary {
    private final SearchAlbumViewModel viewModel;

    public SearchAlbumPresenter(SearchAlbumViewModel searchAlbumViewModel) {
        this.viewModel = searchAlbumViewModel;
    }

    @Override
    public void prepareSuccessView(SearchAlbumOutputData response) {
        SearchAlbumState state = viewModel.getState();
        state.setAlbums(response.getAlbums());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // TODO: To be implemented
    }
}
