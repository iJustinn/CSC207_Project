package use_case.create_playlist;

import entity.Playlist.Playlist;

import java.io.IOException;

public interface CreatePlaylistDataAccessInterface {

    // Create a new playlist in a user's database
    boolean createPlaylist(String username, Playlist playlist) throws IOException;
    boolean checkPlaylistExist(String username, String playlistId) throws IOException;

}
