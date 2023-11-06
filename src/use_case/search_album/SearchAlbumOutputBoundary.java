package use_case.search_album;

public interface SearchAlbumOutputBoundary {
    void prepareSuccessView(SearchAlbumOutputData outputData);

    void prepareFailView(String error);
}
