package spotify.models;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;


public class AlbumSimpleModel {
    private final String id;
    private final String albumName;
    private final String releaseDate;
    private final ArtistSimpleModel[] artists;

    public AlbumSimpleModel(AlbumSimplified album) {
        this.id = album.getId();
        this.albumName = album.getName();
        this.releaseDate = album.getReleaseDate();
        this.artists = album.getArtists();
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

    public ArtistSimpleModel[] getArtists() {
        return artists;
    }
}
