package entity.song;

import entity.album.AlbumSimple;
import entity.artist.ArtistSimple;
import spotify.models.TrackModel;

import java.util.List;

public class SongFull implements ISongFull {
    private final String id;
    private final String name;
    private final Integer discNumber;
    private final Integer durationMs;
    private final Integer trackNumber;
    private final List<ArtistSimple> artists;
    private final AlbumSimple album;
    private final Integer popularity;


    public SongFull(TrackModel track) {
        this.id = track.getId();
        this.name = track.getName();
        this.artists = track.getArtists().stream().map(ArtistSimple::new).toList();
        this.discNumber = track.getDiscNumber();
        this.durationMs = track.getDurationMs();
        this.trackNumber = track.getTrackNumber();
        this.album = new AlbumSimple(track.getAlbum());
        this.popularity = track.getPopularity();
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

    @Override
    public AlbumSimple getAlbum() {
        return album;
    }

    @Override
    public Integer getPopularity() {
        return popularity;
    }
}
