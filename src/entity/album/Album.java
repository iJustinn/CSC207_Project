package entity.album;

import entity.artist.Artist;

public interface Album {
    String getId();
    String getName();
    String[] getGenres();
    Artist[] getArtists();
    String getReleaseDate();
}
