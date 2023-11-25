package use_case.search;

import entity.album.AlbumSimple;
import entity.artist.ArtistSimple;
import entity.Song.SongSimple;

import java.util.List;

public interface SearchDataAccessInterface {
    List<AlbumSimple> searchAlbumsByName(String albumName);
    List<ArtistSimple> searchArtistByName(String artistName);
    List<SongSimple> searchSongByName(String songName);
}
