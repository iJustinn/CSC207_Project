package spotify.models;

import se.michaelthelin.spotify.model_objects.specification.Album;

import java.util.Arrays;
import java.util.List;

public class AlbumModel {
    private final String id;
    private final String name;
    private final String releaseDate;
    private final List<ArtistSimpleModel> artists;

    private final String[] genres;
    private final String label;
    private final Integer popularity;
    private final List<TrackSimpleModel> tracks;

    public AlbumModel(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.releaseDate = album.getReleaseDate();

        this.genres = album.getGenres();
        this.label = album.getLabel();
        this.popularity = album.getPopularity();

        // Map a list of ArtistSimplified to ArtistSimpleModel
        this.artists = Arrays.stream(album.getArtists()).map(ArtistSimpleModel::new).toList();
        this.tracks = Arrays.stream(album.getTracks().getItems()).map(TrackSimpleModel::new).toList();
    }

    public Integer getPopularity() {
        return popularity;
    }

    public List<ArtistSimpleModel> getArtists() {
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

    public List<TrackSimpleModel> getTracks() {
        return tracks;
    }
}
