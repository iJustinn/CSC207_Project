package interface_adapter.delete_song;

import use_case.delete_song.DeleteSongInputBoundary;
import use_case.delete_song.DeleteSongInputData;

public class DeleteSongController {
    private final DeleteSongInputBoundary interactor;

    public DeleteSongController(DeleteSongInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String songId, String palylistId) {
        DeleteSongInputData deleteSongInputData = new DeleteSongInputData(songId, palylistId);
        interactor.execute(deleteSongInputData);
    }
}
