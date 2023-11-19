package spotify.models;


import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

public class TrackSimpleModel {
    private final ArtistSimpleModel[] artists;
    private final Integer discNumber;
    private final Integer durationMs;
    private final String id;
    private final String name;
    private final Integer trackNumber;

    public TrackSimpleModel(TrackSimplified track) {
        this.artists = track.getArtists();
        this.id = track.getId();
        this.discNumber = track.getDiscNumber();
        this.trackNumber = track.getTrackNumber();
        this.name = track.getName();
        this.durationMs = track.getDurationMs();
    }

    public ArtistSimpleModel[] getArtists() {
        return artists;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }
}
