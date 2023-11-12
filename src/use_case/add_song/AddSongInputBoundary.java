package use_case.add_song;

import java.io.IOException;

public interface AddSongInputBoundary {
    void execute(AddSongInputData addSongInputdata) throws IOException;
}
