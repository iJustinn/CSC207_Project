package use_case.view_song;

public class ViewSongInputData {

    final private String playlistName;


    public ViewSongInputData(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }
}
