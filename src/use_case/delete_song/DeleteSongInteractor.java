package use_case.delete_song;

import java.io.IOException;

public class DeleteSongInteractor implements DeleteSongInputBoundary{
    private DeleteSongDataAccessInterface dataAccess;
    private DeleteSongOutputBoundary presenter;

    public DeleteSongInteractor(DeleteSongDataAccessInterface dataAccess,
                                DeleteSongOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(DeleteSongInputData inputData) {
        String username = "TB";
        String PlaylistID = inputData.getPlaylistId();
        boolean success = false;
        try {
            success = dataAccess.deleteSongFromPlaylist(username, PlaylistID, inputData.getSongId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DeleteSongOutputData outputData = new DeleteSongOutputData(success,
                success ? "Song deleted successfully." : "Failed to delete song.");

        if (success) {
            presenter.prepareSuccessView(outputData);
        } else {
            presenter.prepareFailView(outputData);
        }
    }
}
