package interface_adapter.search_artist;

import use_case.search.search_artist.SearchArtistInputBoundary;
import use_case.search.search_artist.SearchArtistInputData;

public class SearchArtistController {
    final SearchArtistInputBoundary interactor;

    public SearchArtistController(SearchArtistInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String search) {
        SearchArtistInputData input = new SearchArtistInputData(search);
        interactor.execute(input);
    }
}
