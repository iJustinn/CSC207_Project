package entity.album;

import entity.artist.IArtistFull;
import entity.song.SongSimple;

public interface IAlbumFull {
    String getId();
    String getName();
    IArtistFull[] getArtists();
    String getReleaseDate();

    String[] getGenres();
    Integer getPopularity();
    String getLabel();
    SongSimple[] getTracklist();
}
