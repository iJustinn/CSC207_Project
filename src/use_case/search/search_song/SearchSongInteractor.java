package use_case.search.search_song;

import use_case.search.SearchDataAccessInterface;

public class SearchSongInteractor implements SearchSongInputBoundary{
    final SearchDataAccessInterface dataAccess;
    final SearchSongOutputBoundary presenter;

    public SearchSongInteractor(SearchDataAccessInterface dataAccess,
                               SearchSongOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchSongInputData input) {

    }
}
