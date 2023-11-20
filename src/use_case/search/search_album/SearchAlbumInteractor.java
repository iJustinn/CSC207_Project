package use_case.search.search_album;

import entity.album.AlbumSimple;
import use_case.search.SearchDataAccessInterface;

import java.util.List;

public class SearchAlbumInteractor implements SearchAlbumInputBoundary {
    final SearchDataAccessInterface dataAccess;
    final SearchAlbumOutputBoundary presenter;

    public SearchAlbumInteractor(SearchDataAccessInterface dataAccess,
                                 SearchAlbumOutputBoundary searchAlbumOutputBoundary) {
        this.dataAccess = dataAccess;
        this.presenter = searchAlbumOutputBoundary;

    }

    @Override
    public void execute(SearchAlbumInputData searchAlbumInputData) {
        String albumName = searchAlbumInputData.getInput();
        List<AlbumSimple> albums = dataAccess.searchAlbumsByName(albumName);
        SearchAlbumOutputData searchAlbumOutputData = new SearchAlbumOutputData(albums);
        presenter.prepareSuccessView(searchAlbumOutputData);
    }
}
