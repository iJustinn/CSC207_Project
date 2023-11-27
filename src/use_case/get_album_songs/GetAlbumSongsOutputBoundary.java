package use_case.get_album_songs;

public interface GetAlbumSongsOutputBoundary {
    void success(GetAlbumSongsOutputData output);

    void fail(String error);
}
