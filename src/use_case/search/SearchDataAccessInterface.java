package use_case.search;

import entity.album.AlbumSimple;
import entity.artist.ArtistSimple;
import entity.song.SongSimple;

public interface SearchDataAccessInterface {
    AlbumSimple[] searchAlbumsByName(String albumName);
    ArtistSimple[] searchArtistByName(String artistName);
    SongSimple[] searchSongByName(String songName);
}
