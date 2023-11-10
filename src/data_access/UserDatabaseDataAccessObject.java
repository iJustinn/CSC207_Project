package data_access;
import entity.Playlist;
import entity.UserDatabase;
import entity.Song;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class UserDatabaseDataAccessObject implements CreatePlaylistDataAccessInterface {

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
            return new UserDatabase();
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

    @Override
    // Add a new song to a specific playlist in a user's database
    public boolean addSongToPlaylist(String username, String playlistId, Song newSong) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);
        UserDatabase.Playlist playlist = userDatabase.getPlaylists().get(playlistId);

        if (playlist == null) {
            System.out.println("Playlist does not exist.");
            return false;
        }

        // Generate a new song ID and add the song to the playlist
        int newSongId = playlist.getSongs().size() + 1;
        playlist.getSong().put(newSongId, newSong);
        playlist.setNumberOfSongs(playlist.getSongs().size());

        // Save the updated database back to the JSON file
        saveUserDatabase(username, userDatabase);
        return true;
    }

    @Override
    // Create a new playlist in a user's database
    public boolean createPlaylist(String username, Playlist playlist) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);

        userDatabase.getPlaylists().put(playlist.getName(), playlist);

        // Save the updated database back to the JSON file
        saveUserDatabase(username, userDatabase);
        return true;
    }

}