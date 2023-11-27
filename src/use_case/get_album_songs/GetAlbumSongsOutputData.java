package use_case.get_album_songs;

import entity.song.*;

import java.util.List;

public class GetAlbumSongsOutputData {
    private final List<Song> songs;

    public GetAlbumSongsOutputData(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
