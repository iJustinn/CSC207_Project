package use_case.search;

import entity.artist.*;
import entity.album.*;
import entity.song.*;

import java.util.List;

public interface SearchDataAccessInterface {
    List<AlbumSimple> searchAlbumsByName(String albumName);
    List<ArtistFull> searchArtistByName(String artistName);
    List<Song> searchSongByName(String songName);
}
