package use_case.delete_playlist;

public class DeletePlaylistInputData {
    private final String playlistId;

    public DeletePlaylistInputData(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistId() {
        return playlistId;
    }
}
