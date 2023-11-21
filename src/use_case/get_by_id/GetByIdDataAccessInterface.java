package use_case.get_by_id;

import entity.album.IAlbumFull;
import entity.artist.IArtistFull;
import entity.song.ISongFull;

public interface GetByIdDataAccessInterface {
    IAlbumFull getAlbumById(String albumId);
    IArtistFull getArtistById(String artistId);
    ISongFull getSongById(String songId);
}
