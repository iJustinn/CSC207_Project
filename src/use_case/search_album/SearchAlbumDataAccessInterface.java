package use_case.search_album;

import entity.album.Album;

public interface SearchAlbumDataAccessInterface {
    Album[] searchAlbumsByString(String albumName);
}
