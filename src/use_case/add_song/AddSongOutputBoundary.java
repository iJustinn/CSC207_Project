package use_case.add_song;

public interface AddSongOutputBoundary {
    void prepareSuccessView(String success);

    void prepareFailView(String error);
}
