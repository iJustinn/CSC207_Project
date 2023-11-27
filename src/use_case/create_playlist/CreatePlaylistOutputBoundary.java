package use_case.create_playlist;

public interface CreatePlaylistOutputBoundary {
    void prepareSuccessView(CreatePlaylistOutputData createPlaylistOutputData, String message);

    void prepareFailView(String message);
}
