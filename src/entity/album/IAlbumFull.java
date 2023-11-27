package entity.album;

import entity.artist.*;
import entity.song.*;

import java.util.List;

public interface IAlbumFull {
    public String getId();
    public String getName();
    public List<ArtistSimple> getArtists();
    public String getReleaseDate();

    public String[] getGenres();
    public Integer getPopularity();
    public String getLabel();
    public List<Song> getTracklist();
}
