package entity.song;

import entity.artist.ArtistSimple;
import entity.album.AlbumSimple;
import spotify.models.AlbumSimpleModel;
import spotify.models.ArtistSimpleModel;

import java.util.List;

public interface ISongFull {
    public Integer getDiscNumber();
    public Integer getDurationMs();
    public String getId();
    public String getName();
    public Integer getTrackNumber();
    public List<ArtistSimple> getArtists();
    public AlbumSimple getAlbum();
    public Integer getPopularity();
}
