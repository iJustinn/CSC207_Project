package use_case.search.search_album;

import entity.album.IAlbumSimple;

import java.util.List;

public class SearchAlbumOutputData {
    private final List<? extends IAlbumSimple> albums;

    public SearchAlbumOutputData(List<? extends IAlbumSimple> albums) {
        this.albums = albums;
    }

    public List<? extends IAlbumSimple> getAlbums() {
        return albums;
    }
}
