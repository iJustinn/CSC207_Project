package entity.album;

import entity.artist.ArtistFull;

public class SpotifyAlbum implements AlbumFull {
    private final String id;
    private final String name;
    private final String[] genres;
    private final ArtistFull[] artists;
    private final String releaseDate;

    SpotifyAlbum(String id,
                 String name,
                 String releaseDate,
                 String[] genres,
                 ArtistFull[] artists) {
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
    public ArtistFull[] getArtists() {
        return artists;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }
}
