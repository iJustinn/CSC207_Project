package entity.artist;

public class SpotifyArtistSimple implements ArtistSimple {
    private final String id;
    private final String name;

    SpotifyArtistSimple(String id,
                        String name,
                        String[] genres) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
