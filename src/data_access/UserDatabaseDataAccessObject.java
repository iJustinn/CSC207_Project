package data_access;
import entity.User.UserDatabase;
import entity.Playlist.Playlist;
import entity.song.Song;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import use_case.add_song.AddSongUserDataAccessInterface;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.delete_playlist.DeletePlaylistDataAccessInterface;
import use_case.delete_song.DeleteSongDataAccessInterface;
import use_case.update_comment.UpdateCommentDataAccessInterface;
import use_case.view_playlists.ViewPlaylistsDataUserAccessInterface;
import use_case.view_song.ViewSongDataAccess;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UserDatabaseDataAccessObject implements AddSongUserDataAccessInterface, CreatePlaylistDataAccessInterface,
        ViewPlaylistsDataUserAccessInterface, ViewSongDataAccess, DeletePlaylistDataAccessInterface, DeleteSongDataAccessInterface,
        UpdateCommentDataAccessInterface {

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
        // Located our target playlist
        Playlist target = userDatabase.getPlaylists().get(playlistId);

        //Add the song to the on memory storage of user's data
        target.getSongs().put(newSong.getId(), newSong);

        //Change the size of the playlist
        target.setNumberOfSongs(target.getSongs().size());

        // Save the updated database back to the JSON file
        saveUserDatabase(username, userDatabase);
        return true;
    }

    @Override
    // Delete a song from a specific playlist in a user's database
    public boolean deleteSongFromPlaylist(String username, String playlistId, String songId) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);

        if(!checkPlaylistExist(username, playlistId)){
            return false;
        }

        // Locate the target playlist
        userDatabase.getPlaylists().get(playlistId).getSongs().remove(songId);


        // Update the number of songs in the playlist
        // userDatabase.setNumberOfSongs(userDatabase.getPlaylists().get(playlistId).getSongs().size());

        // Save the updated database back to the JSON file
        saveUserDatabase(username, userDatabase);
        return true;
    }


    @Override
    public boolean checkSongExist(String username, String playlistId, Song newSong) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);

        //Check to see if the song was already in our playlist
        return userDatabase.getPlaylists().get(playlistId).getSongs().get(newSong.getId()) == null;
    }

    @Override
    public boolean checkPlaylistExist(String username, String playlistId) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);
        // Located our target playlist
        Playlist target = userDatabase.getPlaylists().get(playlistId);

        //Check to see if playlist exists in our user's data
        return target != null;
    }

    @Override
    // Create a new playlist in a user's database
    public boolean createPlaylist(String username, Playlist newPlaylist) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);

        userDatabase.getPlaylists().put(newPlaylist.getName(), newPlaylist);

        // Save the updated database back to the JSON file
        saveUserDatabase(username, userDatabase);
        return true;
    }
    @Override
    // Return a list of playlist names, used by view playlists
    public ArrayList<String> viewPlaylists(String username) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);
        ArrayList<String> names = new ArrayList<String>(userDatabase.getPlaylists().keySet());

        return names;
    }
    @Override
    //Return the songs inside a playlist
    public HashMap<String, Song> getSongsByPlaylistName(String username, String name) throws IOException {
        UserDatabase userDatabase = loadUserDatabase(username);
        Playlist playlist = userDatabase.getPlaylists().get(name);

        HashMap<String, Song> songMap = new HashMap<>();
        if (playlist != null) {
            Iterator<Song> iterator = playlist.iterator();
            while (iterator.hasNext()) {
                Song song = iterator.next();
                songMap.put(song.getId(), song); // Assuming Song has a getId() method
            }
        }
        return songMap;
    }
    @Override
    public boolean deleteplaylist(String username, String deletePlaylist) throws IOException{
        if(!checkPlaylistExist(username,deletePlaylist)){
            return false;
        }
        UserDatabase userdatabase = loadUserDatabase(username);
        userdatabase.getPlaylists().remove(deletePlaylist);

        saveUserDatabase(username, userdatabase);

        return true;

    }

    @Override
    public void addComment(String username, String id, String comment, String playlist) throws IOException {
        UserDatabase userdatabase = loadUserDatabase(username);
        Song song = userdatabase.getPlaylists().get(playlist).getSongs().get(id);
        song.setComment(comment);
        saveUserDatabase(username, userdatabase);
    }

}