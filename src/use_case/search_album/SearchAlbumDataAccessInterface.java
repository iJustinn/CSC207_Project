package use_case.search_album;

import entity.Album;

public interface SearchAlbumDataAccessInterface {
    Album[] searchAlbumsByString(String albumName);
}
