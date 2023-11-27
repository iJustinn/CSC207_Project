package use_case.view_song;

import java.util.ArrayList;

public class ViewSongOutputData {
    private final ArrayList<SongDTO> songs;


    public ViewSongOutputData(ArrayList<SongDTO> songs){
        this.songs = songs;
    }
    public ArrayList<SongDTO> getSongs() {
        return songs;
    }
}
