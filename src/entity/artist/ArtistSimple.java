package entity.artist;

import spotify.models.ArtistSimpleModel;

public class ArtistSimple {
    private final String id;
    private final String name;

    ArtistSimple(String id,
                 String name,
                 String[] genres) {
        this.id = id;
        this.name = name;
    }

    public ArtistSimple(ArtistSimpleModel artist) {
        this.id = artist.getId();
        this.name = artist.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
