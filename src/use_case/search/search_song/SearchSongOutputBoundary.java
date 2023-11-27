package use_case.search.search_song;

public interface SearchSongOutputBoundary {
    void prepareSuccessView(SearchSongOutputData outputData);

    void prepareFailView(String error);
}
