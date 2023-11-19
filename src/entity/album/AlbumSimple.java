package entity.album;

import entity.artist.ArtistFull;

public interface AlbumSimple {
    String getId();
    String getName();
    ArtistFull[] getArtists();
    String getReleaseDate();
}
