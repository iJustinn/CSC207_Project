package use_case.search.search_song;

public interface SearchSongOutputBoundary {
    void prepareSuccessView(SearchSongOutputBoundary outputData);

    void prepareFailView(String error);
}
