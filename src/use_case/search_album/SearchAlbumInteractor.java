package use_case.search_album;

import entity.album.Album;

public class SearchAlbumInteractor implements SearchAlbumInputBoundary {
    final SearchAlbumDataAccessInterface dataAccess;
    final SearchAlbumOutputBoundary presenter;

    public SearchAlbumInteractor(SearchAlbumDataAccessInterface dataAccess,
                                 SearchAlbumOutputBoundary searchAlbumOutputBoundary) {
        this.dataAccess = dataAccess;
        this.presenter = searchAlbumOutputBoundary;

    }

    @Override
    public void execute(SearchAlbumInputData searchAlbumInputData) {
        String albumName = searchAlbumInputData.getAlbumName();
        Album[] albums = dataAccess.searchAlbumsByString(albumName);
        SearchAlbumOutputData searchAlbumOutputData = new SearchAlbumOutputData(albums);
        presenter.prepareSuccessView(searchAlbumOutputData);
    }
}
