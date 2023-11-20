package entity.album;

import entity.artist.ArtistSimple;
import spotify.models.AlbumSimpleModel;

import java.util.List;

public class AlbumSimple implements IAlbumSimple{
    private final String id;
    private final String name;
    private final List<ArtistSimple> artists;
    private final String releaseDate;

    public AlbumSimple(AlbumSimpleModel album) {
        this.id = album.getId();
        this.name = album.getAlbumName();
        this.artists = album.getArtists().stream().map(ArtistSimple::new).toList();
        this.releaseDate = album.getReleaseDate();
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<ArtistSimple> getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return getName();
    }
}
