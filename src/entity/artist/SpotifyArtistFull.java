package entity.artist;

public class SpotifyArtistFull implements ArtistFull {
    private final String id;
    private final String name;
    private final String[] genres;
    private final Integer popularity;

    SpotifyArtistFull(String id,
                      String name,
                      String[] genres,
                      Integer popularity) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.popularity = popularity;
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
    public Integer getPopularity() {
        return popularity;
    }
}
