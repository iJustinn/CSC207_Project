package use_case.get_album_songs;

import data_access.SpotifyDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_album_songs.GetSongsController;
import interface_adapter.get_album_songs.GetSongsPresenter;
import interface_adapter.get_album_songs.GetSongsViewModel;
import org.junit.jupiter.api.Test;
import spotify.SpotifyEndpoint;

import static org.junit.jupiter.api.Assertions.*;

class GetAlbumSongsInteractorTest {

    @Test
    void testE2E() {
        SpotifyEndpoint spotifyEndpoint = new SpotifyEndpoint();
        GetAlbumSongsDataAccessInterface dataAccessInterface = new SpotifyDataAccessObject(spotifyEndpoint);
        GetSongsViewModel viewModel = new GetSongsViewModel();
        ViewManagerModel a = new ViewManagerModel();
        GetAlbumSongsOutputBoundary presenter = new GetSongsPresenter(viewModel, a);
        GetAlbumSongsInputBoundary interactor = new GetAlbumSongsInteractor(dataAccessInterface, presenter);
        GetSongsController controller = new GetSongsController(interactor);
        controller.execute("5zT1JLIj9E57p3e1rFm9Uq");
        assertFalse(viewModel.getState().getSongs().isEmpty());
    }
}