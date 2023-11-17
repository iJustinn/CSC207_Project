// UserDatabase.java in package entity

package entity;

import entity.Playlist.Playlist;

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

    // Method to add a new playlist to the database
    public boolean addPlaylist(String playlistName, Playlist playlist) {
        if (playlists.containsKey(playlistName)) {
            // Playlist already exists
            return false;
        }
        playlists.put(playlistName, playlist);
        return true;
    }

    // Method to retrieve a playlist by name
    public Optional<Playlist> getPlaylist(String playlistName) {
        return Optional.ofNullable(playlists.get(playlistName));
    }

    // More methods could be added for additional functionality, like deleting a playlist, updating a playlist, etc.
}
