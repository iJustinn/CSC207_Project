package use_case.search;

import entity.album.AlbumSimple;
import entity.artist.ArtistFull;

public interface SearchDataAccessInterface {
    AlbumSimple[] searchAlbums(String albumName);
    ArtistFull[] searchArtist(String artistName);
}
