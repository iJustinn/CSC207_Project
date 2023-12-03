package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_album_songs.GetSongsController;
import interface_adapter.get_album_songs.GetSongsPresenter;
import interface_adapter.get_album_songs.GetSongsViewModel;
import interface_adapter.search_album.SearchAlbumController;
import interface_adapter.search_album.SearchAlbumPresenter;
import interface_adapter.search_album.SearchAlbumViewModel;
import interface_adapter.search_artist.SearchArtistController;
import interface_adapter.search_artist.SearchArtistPresenter;
import interface_adapter.search_artist.SearchArtistViewModel;
import interface_adapter.search_song.SearchSongController;
import interface_adapter.search_song.SearchSongPresenter;
import interface_adapter.search_song.SearchSongViewModel;
import use_case.get_album_songs.GetAlbumSongsDataAccessInterface;
import use_case.get_album_songs.GetAlbumSongsInputBoundary;
import use_case.get_album_songs.GetAlbumSongsInteractor;
import use_case.get_album_songs.GetAlbumSongsOutputBoundary;
import use_case.search.SearchDataAccessInterface;
import use_case.search.search_album.SearchAlbumInputBoundary;
import use_case.search.search_album.SearchAlbumInteractor;
import use_case.search.search_album.SearchAlbumOutputBoundary;
import use_case.search.search_artist.SearchArtistInputBoundary;
import use_case.search.search_artist.SearchArtistInteractor;
import use_case.search.search_artist.SearchArtistOutputBoundary;
import use_case.search.search_song.SearchSongInputBoundary;
import use_case.search.search_song.SearchSongInteractor;
import use_case.search.search_song.SearchSongOutputBoundary;
import view.SearchAlbumView;
import view.SearchArtistView;
import view.SearchSongView;


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

    public static SearchSongView song(ViewManagerModel viewManagerModel,
                                      SearchSongViewModel searchSongViewModel,
                                      SearchDataAccessInterface dataAccessInterface) {
        SearchSongOutputBoundary outputBoundary = new SearchSongPresenter(searchSongViewModel);
        SearchSongInputBoundary inputBoundary = new SearchSongInteractor(dataAccessInterface, outputBoundary);
        SearchSongController controller = new SearchSongController(inputBoundary);

        return new SearchSongView(controller, searchSongViewModel);
    }

    public static SearchArtistView artist(ViewManagerModel viewManagerModel,
                                          SearchArtistViewModel searchArtistViewModel,
                                          SearchDataAccessInterface dataAccessInterface) {
        SearchArtistOutputBoundary outputBoundary = new SearchArtistPresenter(searchArtistViewModel);
        SearchArtistInputBoundary inputBoundary = new SearchArtistInteractor(dataAccessInterface, outputBoundary);
        SearchArtistController controller = new SearchArtistController(inputBoundary);
        return new SearchArtistView(controller, searchArtistViewModel);
    }
}
