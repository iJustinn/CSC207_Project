package entity.artist;

import spotify.models.ArtistModel;

public class ArtistFull implements IArtistFull {
    private final String id;
    private final String name;
    private final String[] genres;
    private final Integer popularity;

    ArtistFull(String id, String name, String[] genres, Integer popularity) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.popularity = popularity;
    }

    ArtistFull(ArtistModel artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.genres = artist.getGenres();
        this.popularity = artist.getPopularity();
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
