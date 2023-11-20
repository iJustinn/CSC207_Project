package entity.album;

import entity.artist.ArtistSimple;
import spotify.models.AlbumSimpleModel;
import spotify.models.ArtistSimpleModel;

import java.util.Arrays;
import java.util.List;

public class AlbumSimple {
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<ArtistSimple> getArtists() {
        return artists;
    }
}
