package use_case.add_song;

import entity.Song;

import java.io.IOException;

public interface AddSongUserDataAccessInterface {
    boolean addSongToPlaylist(String username, String playlistId, Song newSong) throws IOException;

    boolean checkSongExist(String username, String playlistId, Song newSong) throws IOException;

    boolean checkPlaylistExist(String username, String playlistId, Song newSong) throws IOException;

}
