package entity.album;

import entity.artist.ArtistSimple;

import java.util.List;

public interface IAlbumSimple {
    public String getId();
    public String getName();
    public String getReleaseDate();
    public List<ArtistSimple> getArtists();
}
