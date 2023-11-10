package entity;

import java.util.Date;
import java.util.HashMap;

public class PlaylistFactory {

    // This method creates a new Playlist with the given name and current date.
    // It initializes the Playlist with no songs.
    public Playlist create(String name) {
        return new Playlist(name, 0, new Date(), new HashMap<>());
    }
}
