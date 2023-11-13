package interface_adapter.search_album;

import use_case.search.search_album.SearchAlbumInputBoundary;

public class SearchAlbumController {
    final SearchAlbumInputBoundary interactor;

    public SearchAlbumController(SearchAlbumInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String search) {
        SearchAlbumInputData input = new SearchAlbumInputData(search);
        interactor.execute(input);
    }
}
