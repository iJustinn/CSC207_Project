package use_case.create_playlist;

import java.io.IOException;

public interface CreatePlaylistInputBoundary {

    void execute(CreatePlaylistInputData createPlaylistInputData) throws IOException;
}
