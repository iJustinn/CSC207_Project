package use_case.search.search_album;

import data_access.SpotifyDataAccessObject;
import interface_adapter.search_album.SearchAlbumController;
import interface_adapter.search_album.SearchAlbumPresenter;
import interface_adapter.search_album.SearchAlbumViewModel;
import org.junit.jupiter.api.Test;
import spotify.SpotifyEndpoint;
import use_case.search.SearchDataAccessInterface;


import static org.junit.jupiter.api.Assertions.*;

class SearchAlbumInteractorTest {
    @Test
    public void testE2E() {
        SpotifyEndpoint spotify = new SpotifyEndpoint();
        SearchDataAccessInterface dataAccess = new SpotifyDataAccessObject(spotify);
        SearchAlbumViewModel viewModel = new SearchAlbumViewModel();
        SearchAlbumOutputBoundary presenter = new SearchAlbumPresenter(viewModel);
        SearchAlbumInputBoundary interactor = new SearchAlbumInteractor(dataAccess, presenter);
        SearchAlbumController controller = new SearchAlbumController(interactor);
        controller.execute("drake");
        assertFalse(viewModel.getState().getAlbums().isEmpty());
    }
}