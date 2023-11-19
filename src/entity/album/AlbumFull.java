package entity.album;

import entity.Song.Song;

public interface AlbumFull extends AlbumSimple {
    Song[] getTracklist();
}
