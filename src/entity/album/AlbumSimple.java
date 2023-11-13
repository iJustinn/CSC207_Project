package entity.album;

import entity.artist.Artist;

public interface AlbumSimple {
    String getId();
    String getName();
    String[] getGenres();
    Artist[] getArtists();
    String getReleaseDate();
}
