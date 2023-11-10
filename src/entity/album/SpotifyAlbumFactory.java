package entity.album;

import entity.artist.Artist;
import spotify.models.AlbumDto;

public class SpotifyAlbumFactory {
    public Album create(String id,
                        String name,
                        String releaseDate,
                        String[] genres,
                        Artist[] artists) {
        return new SpotifyAlbum(id, name, releaseDate, genres, artists);
    }

    public Album[] createMany(AlbumDto[] albumDtos) {
        return new Album[0];
    }
}
