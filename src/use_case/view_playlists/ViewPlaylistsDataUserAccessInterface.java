package use_case.view_playlists;

import java.io.IOException;
import java.util.ArrayList;

public interface ViewPlaylistsDataUserAccessInterface {
    public ArrayList<String> viewPlaylists(String username) throws IOException;
}
