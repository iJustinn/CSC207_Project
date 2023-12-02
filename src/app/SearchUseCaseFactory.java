package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_album_songs.GetSongsController;
import interface_adapter.get_album_songs.GetSongsPresenter;
import interface_adapter.get_album_songs.GetSongsViewModel;
import interface_adapter.search_album.SearchAlbumController;
import interface_adapter.search_album.SearchAlbumPresenter;
import interface_adapter.search_album.SearchAlbumViewModel;
import use_case.get_album_songs.GetAlbumSongsDataAccessInterface;
import use_case.get_album_songs.GetAlbumSongsInputBoundary;
import use_case.get_album_songs.GetAlbumSongsInteractor;
import use_case.get_album_songs.GetAlbumSongsOutputBoundary;
import use_case.search.SearchDataAccessInterface;
import use_case.search.search_album.SearchAlbumInputBoundary;
import use_case.search.search_album.SearchAlbumInteractor;
import use_case.search.search_album.SearchAlbumOutputBoundary;
import view.SearchAlbumView;


public class SearchUseCaseFactory {
    private SearchUseCaseFactory() {}

    public static SearchAlbumView create(ViewManagerModel viewManagerModel,
                                         SearchAlbumViewModel searchAlbumViewModel,
                                         SearchDataAccessInterface dataAccessInterface,
                                         GetSongsViewModel getSongsViewModel,
                                         GetAlbumSongsDataAccessInterface getSongsDA) {

        SearchAlbumOutputBoundary outputBoundary = new SearchAlbumPresenter(searchAlbumViewModel);
        SearchAlbumInputBoundary inputBoundary = new SearchAlbumInteractor(dataAccessInterface, outputBoundary);
        SearchAlbumController controller = new SearchAlbumController(inputBoundary);

        GetAlbumSongsOutputBoundary oBoundary = new GetSongsPresenter(getSongsViewModel, viewManagerModel);
        GetAlbumSongsInputBoundary iBoundary = new GetAlbumSongsInteractor(getSongsDA, oBoundary);

        GetSongsController getSongsController = new GetSongsController(iBoundary);
        return new SearchAlbumView(controller, searchAlbumViewModel, getSongsController, getSongsViewModel);
    }
}
