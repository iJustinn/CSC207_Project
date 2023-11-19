package use_case.add_song;

import entity.Playlist.Playlist;
import entity.Song.Song;

public class AddSongInputData {

    final private Playlist playlist;
    final private Song song;

    public AddSongInputData(String id, Playlist playlist, Song song) {

        this.playlist = playlist;
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public Playlist getPlaylist() {
        return playlist;
    }
}
