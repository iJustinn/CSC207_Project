package entity.artist;

public class SpotifyArtist implements Artist {
    private final String id;
    private final String name;
    private final String[] genres;

    SpotifyArtist(String id,
                  String name,
                  String[] genres) {
        this.id = id;
        this.name = name;
         this.genres = genres;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String[] getGenres() {
        return genres;
    }
}
