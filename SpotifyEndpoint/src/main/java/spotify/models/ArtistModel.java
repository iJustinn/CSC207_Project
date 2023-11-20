package spotify.models;

import se.michaelthelin.spotify.model_objects.specification.Artist;


public class ArtistModel {
    private final String id;
    private final String name;
    private final String[] genres;
    private final Integer popularity;

    public ArtistModel(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.genres = artist.getGenres();
        this.popularity = artist.getPopularity();
    }

    public String[] getGenres() {
        return genres;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPopularity() {
        return popularity;
    }
}
