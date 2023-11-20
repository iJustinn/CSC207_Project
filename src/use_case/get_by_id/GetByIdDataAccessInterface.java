package use_case.get_by_id;

import entity.album.IAlbumFull;
import entity.artist.IArtistFull;
import entity.song.SongFull;

public interface GetByIdDataAccessInterface {
    IAlbumFull getAlbumById(String albumId);
    IArtistFull getArtistById(String artistId);
    SongFull getSongById(String songId);
}
