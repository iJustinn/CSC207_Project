package use_case.get_by_id.get_album;

public interface GetAlbumOutputBoundary {
    void success(GetAlbumOutputData output);
    void fail(String error);
}
