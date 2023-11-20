package spotify.models;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;

import java.util.Arrays;
import java.util.List;


public class AlbumSimpleModel {
    private final String id;
    private final String albumName;
    private final String releaseDate;
    private final List<ArtistSimpleModel> artists;

    public AlbumSimpleModel(AlbumSimplified album) {
        this.id = album.getId();
        this.albumName = album.getName();
        this.releaseDate = album.getReleaseDate();
        this.artists = Arrays.stream(album.getArtists()).map(ArtistSimpleModel::new).toList();
    }

    public String getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<ArtistSimpleModel> getArtists() {
        return artists;
    }
}
