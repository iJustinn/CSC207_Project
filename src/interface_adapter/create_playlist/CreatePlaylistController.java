package interface_adapter.create_playlist;

import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInputData;

import java.io.IOException;

public class CreatePlaylistController {
    private CreatePlaylistInputBoundary interactor;

    public CreatePlaylistController(CreatePlaylistInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void createPlaylist(String playlistName) {
        try {
            interactor.execute(new CreatePlaylistInputData(playlistName));
        } catch (IOException e) {
            // Handle exceptions, possibly logging them and notifying the user
        }
    }
}
