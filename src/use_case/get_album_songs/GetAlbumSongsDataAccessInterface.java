package use_case.get_album_songs;

import entity.song.*;
import java.util.List;

public interface GetAlbumSongsDataAccessInterface {
    List<Song> getAlbumSongs(String id);
}
