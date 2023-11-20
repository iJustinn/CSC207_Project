package entity.album;

import spotify.models.AlbumSimpleModel;

public class AlbumFactory {
    public AlbumSimple createSimpleAlbum(AlbumSimpleModel album) {
        return new AlbumSimple(album);
    }
}
