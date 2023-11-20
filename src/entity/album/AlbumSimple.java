package entity.album;

import entity.artist.ArtistSimple;
import entity.artist.IArtistSimple;
import spotify.models.AlbumSimpleModel;

import java.util.List;

public class AlbumSimple {
    private final String id;
    private final String name;
    private final List<IArtistSimple> artists;
    private final String releaseDate;

    public AlbumSimple(AlbumSimpleModel album) {
        this.id = album.getId();
        this.name = album.getAlbumName();
        this.artists = album.getArtists().stream().map(ArtistSimple::new).toList();
        this.releaseDate = album.getReleaseDate();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<IArtistSimple> getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return getName();
    }
}
