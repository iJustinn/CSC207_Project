package use_case.create_playlist;

public class CreatePlaylistOutputData {

    private final String playlistName;
    private final String creationDateTime;

    public CreatePlaylistOutputData(String playlistName, String creationDateTime) {
        this.playlistName = playlistName;
        this.creationDateTime = creationDateTime;
    }

    public String getPlaylistName(){return playlistName;}
    public String getCreationDateTime(){return creationDateTime;}
}
