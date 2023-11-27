package use_case.view_playlists;

import java.io.IOException;

public interface ViewPlaylistsInputBoundary {
    void execute(String user) throws IOException;
}
