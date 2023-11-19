package use_case.search.search_album;

import entity.album.AlbumSimple;

import java.util.List;

public class SearchAlbumOutputData {
    private final List<AlbumSimple> albums;

    public SearchAlbumOutputData(List<AlbumSimple> albums) {
        this.albums = albums;
    }

    public List<AlbumSimple> getAlbums() {
        return albums;
    }
}
