package use_case.view_song;

import java.io.IOException;

public interface ViewSongInputBound {
    void execute(String user, ViewSongInputData viewSongInputData) throws IOException;
}
