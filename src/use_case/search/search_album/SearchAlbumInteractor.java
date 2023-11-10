package use_case.search.search_album;

import entity.album.Album;
import use_case.search.SearchDataAccessInterface;
import use_case.search.SearchInputData;

public class SearchAlbumInteractor implements SearchAlbumInputBoundary {
    final SearchDataAccessInterface dataAccess;
    final SearchAlbumOutputBoundary presenter;

    public SearchAlbumInteractor(SearchDataAccessInterface dataAccess,
                                 SearchAlbumOutputBoundary searchAlbumOutputBoundary) {
        this.dataAccess = dataAccess;
        this.presenter = searchAlbumOutputBoundary;

    }

    @Override
    public void execute(SearchInputData searchAlbumInputData) {
        String albumName = searchAlbumInputData.getInput();
        Album[] albums = dataAccess.searchAlbums(albumName);
        SearchAlbumOutputData searchAlbumOutputData = new SearchAlbumOutputData(albums);
        presenter.prepareSuccessView(searchAlbumOutputData);
    }
}
