package use_case.delete_playlist;

import java.io.IOException;

public class DeletePlaylistInteractor implements DeletePlaylistInputBoundary{
    final DeletePlaylistDataAccessInterface deleteDAO;

    final DeletePlaylistOutputBoundary DeletePresenter;

    public DeletePlaylistInteractor(DeletePlaylistDataAccessInterface dataAccess,
                                    DeletePlaylistOutputBoundary presenter) {
        this.deleteDAO = dataAccess;
        this.DeletePresenter = presenter;
    }
    @Override
    public void execute(DeletePlaylistInputData deletePlaylistInputData) throws IOException {
        String username = "Alice"; // for testing

        boolean success = deleteDAO.deletePlaylist(username, deletePlaylistInputData.getPlaylistId());
        String message = success ? "Playlist deleted successfully." : "Failed to delete playlist.";
        DeletePlaylistOutputData outputData = new DeletePlaylistOutputData(success, message);

        if (success) {
            DeletePresenter.prepareSuccessView(outputData);
        } else {
            DeletePresenter.prepareFailView(outputData);
        }
    }


}
