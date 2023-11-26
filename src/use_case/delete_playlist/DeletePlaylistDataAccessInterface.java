package use_case.delete_playlist;

import java.io.IOException;

public interface DeletePlaylistDataAccessInterface {
    boolean deleteplaylist(String username, String PlaylistId) throws IOException;
}
