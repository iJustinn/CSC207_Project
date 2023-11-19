package entity.album;

import entity.Song;
import entity.artist.ArtistFull;

public interface AlbumFull {
    String getId();
    String getName();
    ArtistFull[] getArtists();
    String getReleaseDate();

    String[] getGenres();
    Integer getPopularity();
    String getLabel();
    Song[] getTracklist();
}
