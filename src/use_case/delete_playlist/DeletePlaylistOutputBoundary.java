package use_case.delete_playlist;

public interface DeletePlaylistOutputBoundary {
    void prepareSuccessView(DeletePlaylistOutputData deletePlaylistOutputData);
    void prepareFailView(DeletePlaylistOutputData deletePlaylistOutputData);
}
