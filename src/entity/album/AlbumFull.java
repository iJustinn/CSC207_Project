package entity.album;

import entity.Song;

public interface AlbumFull extends AlbumSimple {
    String[] getGenres();
    Integer getPopularity();
    String getLabel();
    Song[] getTracklist();
}
