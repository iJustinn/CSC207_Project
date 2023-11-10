package use_case.search;

import entity.album.Album;
import entity.artist.Artist;

public interface SearchDataAccessInterface {
    Album[] searchAlbums(String albumName);
    Artist[] searchArtist(String artistName);
}
