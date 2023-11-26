package use_case.get_by_id.get_album;

import entity.album.IAlbumFull;

public class GetAlbumOutputData {
    private final IAlbumFull album;

    public GetAlbumOutputData(IAlbumFull album) {
        this.album = album;
    }

    public IAlbumFull getAlbum() {
        return album;
    }
}
