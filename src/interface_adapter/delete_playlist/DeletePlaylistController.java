package interface_adapter.delete_playlist;

import use_case.delete_playlist.DeletePlaylistInputBoundary;
import use_case.delete_playlist.DeletePlaylistInputData;

import java.io.IOException;

public class DeletePlaylistController {
    private final DeletePlaylistInputBoundary interactor;

    public DeletePlaylistController(DeletePlaylistInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void deletePlaylist(String playlistId) throws IOException {
        DeletePlaylistInputData inputData = new DeletePlaylistInputData(playlistId);
        interactor.execute(inputData);
    }
}
