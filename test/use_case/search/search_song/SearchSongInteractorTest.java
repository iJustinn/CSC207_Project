package use_case.search.search_song;

import data_access.SpotifyDataAccessObject;
import interface_adapter.search_song.SearchSongController;
import interface_adapter.search_song.SearchSongPresenter;
import interface_adapter.search_song.SearchSongViewModel;
import org.junit.jupiter.api.Test;
import spotify.SpotifyEndpoint;
import use_case.search.SearchDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class SearchSongInteractorTest {

    @Test
    public void testE2E() {
        SpotifyEndpoint spotifyEndpoint = new SpotifyEndpoint();
        SearchDataAccessInterface dataAccessInterface = new SpotifyDataAccessObject(spotifyEndpoint);
        SearchSongViewModel viewModel = new SearchSongViewModel();
        SearchSongOutputBoundary presenter = new SearchSongPresenter(viewModel);
        SearchSongInputBoundary interactor = new SearchSongInteractor(dataAccessInterface, presenter);
        SearchSongController controller = new SearchSongController(interactor);
        controller.execute("drake");
        assertFalse(viewModel.getState().getSongs().isEmpty());
    }
}