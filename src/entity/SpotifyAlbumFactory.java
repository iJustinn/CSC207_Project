package entity;

public class SpotifyAlbumFactory implements AlbumFactory {
    @Override
    public Album create(String id,
                        String name,
                        String releaseDate,
                        String[] genres,
                        Artist[] artists) {
        return new SpotifyAlbum(id, name, releaseDate, genres, artists);
    }
}
