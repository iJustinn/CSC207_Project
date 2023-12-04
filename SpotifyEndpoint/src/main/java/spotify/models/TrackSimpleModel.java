package spotify.models;


import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

import java.util.Arrays;
import java.util.List;

public class TrackSimpleModel {
    private final List<ArtistSimpleModel> artists;
    private final Integer discNumber;
    private final Integer durationMs;
    private final String id;
    private final String name;
    private final Integer trackNumber;

    public TrackSimpleModel(TrackSimplified track) {
        this.id = track.getId();
        this.discNumber = track.getDiscNumber();
        this.trackNumber = track.getTrackNumber();
        this.name = track.getName();
        this.durationMs = track.getDurationMs();
        this.artists = Arrays.stream(track.getArtists()).map(ArtistSimpleModel::new).toList();
    }

    public List<ArtistSimpleModel> getArtists() {
        return artists;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
