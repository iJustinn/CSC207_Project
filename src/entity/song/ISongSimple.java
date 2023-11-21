package entity.song;

import entity.artist.ArtistSimple;
import java.util.List;

public interface ISongSimple {
    public Integer getDiscNumber();
    public Integer getDurationMs();
    public String getId();
    public String getName();
    public Integer getTrackNumber();
    public List<ArtistSimple> getArtists();
}
