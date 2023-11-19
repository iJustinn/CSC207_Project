package use_case.get_by_id;

import entity.album.AlbumFull;
import entity.artist.ArtistFull;
import entity.song.SongFull;

public interface GetByIdDataAccessInterface {
    AlbumFull getAlbumById(String albumId);
    ArtistFull getArtistById(String artistId);
    SongFull getSongById(String songId);
}
