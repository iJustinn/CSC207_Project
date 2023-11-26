package use_case.search.search_album;

import entity.album.IAlbumSimple;

import java.util.List;

public class SearchAlbumOutputData {
    private final List<IAlbumSimple> albums;

    public SearchAlbumOutputData(List<IAlbumSimple> albums) {
        this.albums = albums;
    }

    public List<IAlbumSimple> getAlbums() {
        return albums;
    }
}
