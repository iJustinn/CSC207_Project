package use_case.delete_playlist;

public interface DeletePlaylistDataAccessInterface {
    boolean deletePlaylist(String username, String PlaylistId);
}
