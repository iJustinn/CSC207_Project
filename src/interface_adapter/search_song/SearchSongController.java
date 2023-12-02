package interface_adapter.search_song;

import use_case.search.search_song.SearchSongInputBoundary;
import use_case.search.search_song.SearchSongInputData;

public class SearchSongController {
    final SearchSongInputBoundary interactor;

    public SearchSongController(SearchSongInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String search) {
        SearchSongInputData input = new SearchSongInputData(search);
        interactor.execute(input);
    }
}
