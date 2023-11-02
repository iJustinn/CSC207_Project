package entity;

public class SpotifyAlbum implements Album {
    private final String id;
    private final String name;
    private final String releaseDate;

    SpotifyAlbum(String id, String name, String releaseDate) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
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
    public String getReleaseDate() {
        return releaseDate;
    }
}
