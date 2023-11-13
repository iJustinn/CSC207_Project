package entity.album;

import entity.Song;

public interface AlbumFull extends AlbumSimple {
    Song[] getTracklist();
}
