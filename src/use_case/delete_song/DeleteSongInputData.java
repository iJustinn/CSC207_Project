package use_case.delete_song;

public class DeleteSongInputData {
    private final String songId;

    private final String playlistId;

    public DeleteSongInputData(String songId, String playlistId) {
        this.songId = songId;
        this.playlistId = playlistId;
    }

    public String getSongId() {
        return songId;
    }

    public String getPlaylistId() {
        return playlistId;
    }
}
