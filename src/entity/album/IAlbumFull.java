package entity.album;

import entity.artist.ArtistSimple;
import entity.song.SongSimple;
import java.util.List;

public interface IAlbumFull {
    String getId();
    String getName();
    List<ArtistSimple> getArtists();
    String getReleaseDate();

    String[] getGenres();
    Integer getPopularity();
    String getLabel();
    List<SongSimple> getTracklist();
}
