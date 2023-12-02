package interface_adapter.search_artist;

import use_case.search.search_artist.SearchArtistOutputBoundary;
import use_case.search.search_artist.SearchArtistOutputData;

public class SearchArtistPresenter implements SearchArtistOutputBoundary {
    private final SearchArtistViewModel viewModel;

    public SearchArtistPresenter(SearchArtistViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(SearchArtistOutputData outputData) {
        SearchArtistState state = viewModel.getState();
        state.setArtists(outputData.getArtists());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // TODO: To be implemented
    }
}
