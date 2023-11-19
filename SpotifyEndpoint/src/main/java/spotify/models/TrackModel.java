package spotify.models;


import se.michaelthelin.spotify.model_objects.specification.Track;

public class TrackModel {
    private final AlbumSimpleModel album;
    private final ArtistSimpleModel[] artists;
    private final Integer discNumber;
    private final Integer durationMs;
    private final String id;
    private final String name;
    private final Integer popularity;
    private final Integer trackNumber;

    public TrackModel(Track track) {
        this.album = new AlbumSimpleModel(track.getAlbum());
        this.artists = track.getArtists();
        this.id = track.getId();
        this.discNumber = track.getDiscNumber();
        this.trackNumber = track.getTrackNumber();
        this.popularity = track.getPopularity();
        this.name = track.getName();
        this.durationMs = track.getDurationMs();
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public ArtistSimpleModel[] getArtists() {
        return artists;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AlbumSimpleModel getAlbum() {
        return album;
    }
}
