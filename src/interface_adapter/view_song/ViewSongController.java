package interface_adapter.view_song;

import use_case.view_song.ViewSongInputBound;
import use_case.view_song.ViewSongInputData;

import java.io.IOException;

public class ViewSongController {
    private final ViewSongInputBound viewSongInteractor;

    public ViewSongController(ViewSongInputBound viewSongInteractor) {
        this.viewSongInteractor = viewSongInteractor;
    }

    public void execute(String user, String playlistName) throws IOException {
        viewSongInteractor.execute(user, new ViewSongInputData(playlistName));
    }
}
