package entity.artist;

import spotify.models.ArtistSimpleModel;

public class ArtistSimple implements IArtistSimple {
    private final String id;
    private final String name;

    public ArtistSimple(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ArtistSimple(ArtistSimpleModel artist) {
        this.id = artist.getId();
        this.name = artist.getName();
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
