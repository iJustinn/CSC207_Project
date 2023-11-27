package use_case.view_playlists;

import java.util.ArrayList;

public class ViewPlaylistsOutputData {
    private ArrayList<String> playlists;

    public ViewPlaylistsOutputData(ArrayList<String> playlists){
        this.playlists = playlists;
    }

    public ArrayList<String> getPlaylists() {
        return playlists;
    }
}
