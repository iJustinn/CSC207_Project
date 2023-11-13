package use_case.search.search_artist;

import use_case.search.SearchInputData;

public interface SearchArtistInputBoundary {
    void execute(SearchInputData searchAlbumInputData);
}
