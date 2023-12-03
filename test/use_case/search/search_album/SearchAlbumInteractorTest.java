package use_case.search.search_album;

import data_access.SpotifyDataAccessObject;
import interface_adapter.search_album.SearchAlbumPresenter;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import spotify.SpotifyEndpoint;
import use_case.search.SearchDataAccessInterface;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchAlbumInteractorTest {
    private SearchDataAccessInterface dataAccess;
    private SearchAlbumInputBoundary interactor;
    private SearchAlbumOutputBoundary presenter;

    @Before
    public void setUp() {
        SpotifyEndpoint spotify = new SpotifyEndpoint();
        dataAccess = new SpotifyDataAccessObject(spotify);
        presenter = mock(SearchAlbumOutputBoundary.class);
        interactor = new SearchAlbumInteractor(dataAccess, presenter);
    }

    @Test void testExecute() {
        SearchAlbumInputData input = new SearchAlbumInputData("drake");
        interactor.execute(input);
    }
}