package use_case.search.search_album;

public interface SearchAlbumOutputBoundary {
    void prepareSuccessView(SearchAlbumOutputData outputData);

    void prepareFailView(String error);
}
