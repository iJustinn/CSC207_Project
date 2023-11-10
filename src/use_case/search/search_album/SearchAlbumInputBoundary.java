package use_case.search.search_album;

import use_case.search.SearchInputData;

public interface SearchAlbumInputBoundary {
    void execute(SearchInputData searchAlbumInputData);
}
