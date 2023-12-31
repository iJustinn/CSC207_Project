package use_case.delete_song;

import entity.song.Song;

import java.io.IOException;

public interface DeleteSongDataAccessInterface {

    boolean deleteSongFromPlaylist(String username, String playlistId, String songId) throws IOException;
}
