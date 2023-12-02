package interface_adapter.search_song;

import use_case.search.search_song.SearchSongOutputBoundary;
import use_case.search.search_song.SearchSongOutputData;

public class SearchSongPresenter implements SearchSongOutputBoundary {
    private final SearchSongViewModel viewModel;

    public SearchSongPresenter(SearchSongViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(SearchSongOutputData outputData) {
        SearchSongState state = viewModel.getState();
        state.setSongs(outputData.getSongs());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // TODO: To be implemented
    }
}
