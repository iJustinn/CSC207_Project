package use_case.view_song;

import entity.Song.Song;

import java.io.IOException;
import java.util.HashMap;

public interface ViewSongDataAccess {
    public HashMap<String, Song> getSongsByPlaylistName(String user, String name) throws IOException;
}
