package use_case.create_playlist;

public class CreatePlaylistInputData {

    final private String playlistName;

    public CreatePlaylistInputData(String playlistName) {
    this.playlistName = playlistName;
    }
    public String getPlaylistName() {return playlistName;}
}
