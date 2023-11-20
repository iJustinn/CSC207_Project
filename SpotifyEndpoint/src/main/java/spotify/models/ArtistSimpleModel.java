package spotify.models;


import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

public class ArtistSimpleModel {
    private final String id;
    private final String name;

    public ArtistSimpleModel(ArtistSimplified artist) {
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
