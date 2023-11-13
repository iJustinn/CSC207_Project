package entity.album;

import entity.artist.Artist;

public class SpotifyAlbum implements AlbumSimple {
    private final String id;
    private final String name;
    private final String[] genres;
    private final Artist[] artists;
    private final String releaseDate;

    SpotifyAlbum(String id,
                 String name,
                 String releaseDate,
                 String[] genres,
                 Artist[] artists) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.artists = artists;
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
    public String[] getGenres() {
        return genres;
    }

    @Override
    public Artist[] getArtists() {
        return artists;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }
}
