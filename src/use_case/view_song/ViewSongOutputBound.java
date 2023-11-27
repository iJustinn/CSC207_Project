package use_case.view_song;

import use_case.login.LoginOutputData;

public interface ViewSongOutputBound {
    void prepareSuccessView(ViewSongOutputData songs);
}
