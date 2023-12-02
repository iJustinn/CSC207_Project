package entity.Playlist;

public interface IPlaylistFactory {
    Playlist create(String name);
    KpopPalylist kpop_create(String name);

}
