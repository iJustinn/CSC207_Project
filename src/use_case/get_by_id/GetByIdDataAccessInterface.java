package use_case.get_by_id;

import entity.artist.*;
import entity.album.*;
import entity.song.*;

public interface GetByIdDataAccessInterface {
    AlbumFull getAlbumById(String albumId);
    ArtistFull getArtistById(String artistId);
    Song getSongById(String songId);
}
