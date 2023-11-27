package interface_adapter.view_song;

import use_case.view_song.SongDTO;

import java.util.ArrayList;

public class ViewSongState {
    private ArrayList<SongDTO> songs;

    public ArrayList<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<SongDTO> songs) {
        this.songs = songs;
    }
}
