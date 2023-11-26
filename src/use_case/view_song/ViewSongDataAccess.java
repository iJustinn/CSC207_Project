package use_case.view_song;

import entity.Song.Song;

import java.io.IOException;
import java.util.HashMap;

public interface ViewSongDataAccess {
    public HashMap<String, Song> getSongsByPlaylistName(String username, String name) throws IOException;
}
