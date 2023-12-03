package entity.Playlist;

public interface IPlaylistFactory {
    Playlist create(String name);
    KpopPlaylist kpop_create(String name);

}
