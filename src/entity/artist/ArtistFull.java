package entity.artist;

public class ArtistFull {
    private final String id;
    private final String name;
    private final String[] genres;
    private final Integer popularity;

    ArtistFull(String id,
               String name,
               String[] genres,
               Integer popularity) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.popularity = popularity;
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

    public Integer getPopularity() {
        return popularity;
    }
}
