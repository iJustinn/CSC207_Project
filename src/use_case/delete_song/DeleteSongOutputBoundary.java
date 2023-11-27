package use_case.delete_song;

public interface DeleteSongOutputBoundary {
    void prepareSuccessView(DeleteSongOutputData outputData);
    void prepareFailView(DeleteSongOutputData outputData);
}
