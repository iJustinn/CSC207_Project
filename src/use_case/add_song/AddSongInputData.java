package use_case.add_song;

import entity.Playlist.Playlist;
import entity.song.Song;

public class AddSongInputData {

    final private String playlist;
    final private Song song;

    public AddSongInputData(String playlist, Song song) {

        this.playlist = playlist;
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public String getPlaylist() {
        return playlist;
    }
}
