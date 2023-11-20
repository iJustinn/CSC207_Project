package use_case.search.search_artist;

public interface SearchArtistOutputBoundary {
    void prepareSuccessView(SearchArtistOutputData outputData);

    void prepareFailView(String error);
}
