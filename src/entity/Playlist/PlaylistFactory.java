package entity.Playlist;

import java.util.Date;
import java.util.HashMap;

public class PlaylistFactory implements IPlaylistFactory {

    // This method creates a new Playlist with the given name and current date.
    // It initializes the Playlist with no songs.
    public Playlist create(String name) {
        return new Playlist(name, 0, new Date(), new HashMap<>());
    }
}
