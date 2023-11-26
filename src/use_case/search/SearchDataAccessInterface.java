package use_case.search;

import entity.album.IAlbumSimple;
import entity.artist.IArtistFull;
import entity.song.ISongFull;

import java.util.List;

public interface SearchDataAccessInterface {
    List<? extends IAlbumSimple> searchAlbumsByName(String albumName);
    List<? extends IArtistFull> searchArtistByName(String artistName);
    List<? extends ISongFull> searchSongByName(String songName);
}
