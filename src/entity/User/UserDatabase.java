package entity.User;

import entity.Playlist.Playlist;
import entity.song.Song;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDatabase {
    private Map<String, Playlist> playlists;

    // Constructor
    public UserDatabase() {
        this.playlists = new HashMap<>();
    }

    // Getter and Setter
    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Map<String, Playlist> playlists) {
        this.playlists = playlists;
    }

}
