package entity.artist;

public class SpotifyArtistFactory {
    public ArtistFull create(String id, String name, String[] genres) {
        return new SpotifyArtist(id, name, genres);
    }
}
