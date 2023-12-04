package use_case.search.search_artist;

import data_access.SpotifyDataAccessObject;
import interface_adapter.search_artist.SearchArtistController;
import interface_adapter.search_artist.SearchArtistPresenter;
import interface_adapter.search_artist.SearchArtistViewModel;
import org.junit.jupiter.api.Test;
import spotify.SpotifyEndpoint;
import use_case.search.SearchDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class SearchArtistInteractorTest {
    @Test
    public void testE2E() {
        SpotifyEndpoint spotifyEndpoint = new SpotifyEndpoint();
        SearchDataAccessInterface dataAccessInterface = new SpotifyDataAccessObject(spotifyEndpoint);
        SearchArtistViewModel viewModel = new SearchArtistViewModel();
        SearchArtistOutputBoundary presenter = new SearchArtistPresenter(viewModel);
        SearchArtistInputBoundary interactor = new SearchArtistInteractor(dataAccessInterface, presenter);
        SearchArtistController controller = new SearchArtistController(interactor);
        controller.execute("drake");
        assertFalse(viewModel.getState().getArtists().isEmpty());
    }
}