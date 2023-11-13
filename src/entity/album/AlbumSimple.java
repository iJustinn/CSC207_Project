package entity.album;

import entity.artist.ArtistFull;

public interface AlbumSimple {
    String getId();
    String getName();
    String[] getGenres();
    ArtistFull[] getArtists();
    String getReleaseDate();
}
