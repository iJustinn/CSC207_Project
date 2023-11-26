package use_case.search.search_artist;

import entity.artist.IArtistFull;
import use_case.search.SearchDataAccessInterface;

import java.util.List;

public class SearchArtistInteractor implements SearchArtistInputBoundary {
    final SearchDataAccessInterface dataAccess;
    final SearchArtistOutputBoundary presenter;

    public SearchArtistInteractor(SearchDataAccessInterface dataAccess,
                                  SearchArtistOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchArtistInputData searchArtistInputData) {
        String artistName = searchArtistInputData.getInput();
        List<IArtistFull> artists = dataAccess.searchArtistByName(artistName);
        SearchArtistOutputData outputData = new SearchArtistOutputData(artists);
        presenter.prepareSuccessView(outputData);
    }
}
