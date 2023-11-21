package entity.album;

import entity.artist.ArtistSimple;
import entity.song.SongSimple;
import spotify.models.AlbumModel;
import java.util.List;


public class AlbumFull implements IAlbumFull {
    private final String id;
    private final String name;
    private final List<ArtistSimple> artists;
    private final String releaseDate;
    private final String[] genres;
    private final Integer popularity;
    private final String label;
    private final List<SongSimple> trackList;

    public AlbumFull(AlbumModel album) {
        this.id = album.getId();
        this.name = album.getName();
        this.artists = album.getArtists().stream().map(ArtistSimple::new).toList();
        this.releaseDate = album.getReleaseDate();
        this.genres = album.getGenres();
        this.popularity = album.getPopularity();
        this.label = album.getLabel();
        this.trackList = album.getTracks().stream().map(SongSimple::new).toList();
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
    public List<ArtistSimple> getArtists() {
        return artists;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String[] getGenres() {
        return genres;
    }

    @Override
    public Integer getPopularity() {
        return popularity;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public List<SongSimple> getTracklist() {
        return trackList;
    }
}
