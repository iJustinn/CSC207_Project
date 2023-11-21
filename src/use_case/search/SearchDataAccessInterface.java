package use_case.search;

import entity.album.AlbumSimple;
import entity.artist.IArtistSimple;
import entity.song.ISongSimple;

import java.util.List;

public interface SearchDataAccessInterface {
    List<AlbumSimple> searchAlbumsByName(String albumName);
    List<IArtistSimple> searchArtistByName(String artistName);
    List<ISongSimple> searchSongByName(String songName);
}
