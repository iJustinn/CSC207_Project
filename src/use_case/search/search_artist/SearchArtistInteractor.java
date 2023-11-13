package use_case.search.search_artist;

import entity.artist.Artist;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchInputData;

public class SearchArtistInteractor implements SearchArtistInputBoundary {
    final SearchDataAccessInterface dataAccess;
    final SearchArtistOutputBoundary presenter;

    public SearchArtistInteractor(SearchDataAccessInterface dataAccess,
                                  SearchArtistOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchInputData searchAlbumInputData) {
        String artistName = searchAlbumInputData.getInput();
        Artist[] artists = dataAccess.searchArtist(artistName);
        SearchArtistOutputData outputData = new SearchArtistOutputData(artists);
        presenter.prepareSuccessView(outputData);
    }
}
