package entity.Song;

import entity.artist.ArtistSimple;
import spotify.models.TrackSimpleModel;

import java.util.List;

public class SongSimple implements ISongSimple {
    private final String id;
    private final String name;
    private final Integer discNumber;
    private final Integer durationMs;
    private final Integer trackNumber;
    private final List<ArtistSimple> artists;

    public SongSimple(TrackSimpleModel track) {
        this.id = track.getId();
        this.name = track.getName();
        this.artists = track.getArtists().stream().map(ArtistSimple::new).toList();
        this.discNumber = track.getDiscNumber();
        this.durationMs = track.getDurationMs();
        this.trackNumber = track.getTrackNumber();
    }

    @Override
    public Integer getDiscNumber() {
        return discNumber;
    }

    @Override
    public Integer getDurationMs() {
        return durationMs;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getTrackNumber() {
        return trackNumber;
    }

    @Override
    public List<ArtistSimple> getArtists() {
        return artists;
    }
}
