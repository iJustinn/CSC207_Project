package use_case.search;

import entity.album.AlbumSimple;
import entity.artist.Artist;

public interface SearchDataAccessInterface {
    AlbumSimple[] searchAlbums(String albumName);
    Artist[] searchArtist(String artistName);
}
