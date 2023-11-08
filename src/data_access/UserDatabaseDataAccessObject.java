package data_access;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

public class UserDatabaseDataAccessObject {

    private final ObjectMapper objectMapper; // Jackson's object mapper for JSON serialization/deserialization
    private final String storageDirectory; // The directory path where the user databases are stored

    public UserDatabaseDataAccessObject(String storageDirectory) {
        this.storageDirectory = storageDirectory;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty print the JSON
        this.objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); // Set the date format
    }

    // Load a user's entire playlist database from a JSON file
    public UserDatabase loadUserDatabase(String username) throws IOException {
        File file = new File(storageDirectory, username + "_playlists.json");
        if (!file.exists()) {
            // If the file doesn't exist, return an empty database
            return new UserDatabase(new HashMap<>());
        }
        // Deserialize the JSON file to a UserDatabase object
        return objectMapper.readValue(file, new TypeReference<UserDatabase>() {});
    }

    // Save a user's entire playlist database to a JSON file
    public void saveUserDatabase(String username, UserDatabase userDatabase) throws IOException {
        File file = new File(storageDirectory, username + "_playlists.json");
        // Serialize the UserDatabase object to a JSON file
        objectMapper.writeValue(file, userDatabase);
    }

    // Get a specific playlist from a user's database
    public Optional<UserDatabase.Playlist> getPlaylist(String username, String playlistId) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);
        // Retrieve a playlist by ID from the user's playlists map
        return Optional.ofNullable(userDatabase.getPlaylists().get(playlistId));
    }

    // Add a new song to a specific playlist in a user's database
    public boolean addSongToPlaylist(String username, String playlistId, UserDatabase.Song newSong) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);
        UserDatabase.Playlist playlist = userDatabase.getPlaylists().get(playlistId);

        if (playlist == null) {
            System.out.println("Playlist does not exist.");
            return false;
        }

        // Generate a new song ID and add the song to the playlist
        int newSongId = playlist.getSongs().size() + 1;
        playlist.getSongs().put(newSongId, newSong);
        playlist.setNumberOfSongs(playlist.getSongs().size());

        // Save the updated database back to the JSON file
        saveUserDatabase(username, userDatabase);
        return true;
    }

    // Create a new playlist in a user's database
    public boolean createPlaylist(String username, String playlistId) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);

        if (userDatabase.getPlaylists().containsKey(playlistId)) {
            System.out.println("Playlist already exists.");
            return false;
        }

        // Create a new playlist and add it to the user's playlists map
        UserDatabase.Playlist newPlaylist = new UserDatabase.Playlist(playlistId, 0, new Date(), new HashMap<>());
        userDatabase.getPlaylists().put(playlistId, newPlaylist);

        // Save the updated database back to the JSON file
        saveUserDatabase(username, userDatabase);
        return true;
    }
}
