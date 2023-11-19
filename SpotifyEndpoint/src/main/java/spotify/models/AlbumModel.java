package spotify.models;

import se.michaelthelin.spotify.model_objects.specification.Album;

public class AlbumModel {
    private final String id;
    private final String name;
    private final String releaseDate;
    private final ArtistSimpleModel[] artists;

    private final String[] genres;
    private final String label;
    private final Integer popularity;
    private final TrackSimpleModel[] tracks;

    public AlbumModel(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.releaseDate = album.getReleaseDate();
        this.artists = album.getArtists();

        this.genres = album.getGenres();
        this.label = album.getLabel();
        this.popularity = album.getPopularity();
        this.tracks = album.getTracks();
    }

    public Integer getPopularity() {
        return popularity;
    }

    public ArtistSimpleModel[] getArtists() {
        return artists;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getGenres() {
        return genres;
    }

    public String getLabel() {
        return label;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public TrackSimpleModel[] getTracks() {
        return tracks;
    }
}
