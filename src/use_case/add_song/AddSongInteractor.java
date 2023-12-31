package use_case.add_song;

import java.io.IOException;

public class AddSongInteractor implements AddSongInputBoundary{
    final AddSongUserDataAccessInterface addSongDataAccessObject;
    final AddSongOutputBoundary addSongPresenter;

    public AddSongInteractor(AddSongUserDataAccessInterface addSongDataAccessObject, AddSongOutputBoundary addSongPresenter) {
        this.addSongDataAccessObject = addSongDataAccessObject;
        this.addSongPresenter = addSongPresenter;
    }


    @Override
    public void execute(AddSongInputData addSongInputdata) throws IOException {
        if (! addSongDataAccessObject.checkPlaylistExist("Alice", addSongInputdata.getPlaylist())){
            addSongPresenter.prepareFailView("This playlist does not exist.");
        } else if (! addSongDataAccessObject.checkSongExist("Alice", addSongInputdata.getPlaylist(), addSongInputdata.getSong())) {
            addSongPresenter.prepareFailView("This song is already in the playlist.");
        } else {

            addSongDataAccessObject.addSongToPlaylist("Alice", addSongInputdata.getPlaylist(), addSongInputdata.getSong());
            addSongPresenter.prepareSuccessView("The song was successfully added.");
        }
    }
}
