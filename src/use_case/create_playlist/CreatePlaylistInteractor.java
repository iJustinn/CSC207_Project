package use_case.create_playlist;

import entity.Playlist;
import entity.PlaylistFactory;
import entity.UserDatabase;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.create_playlist.CreatePlaylistInputData;
import use_case.create_playlist.CreatePlaylistOutputBoundary;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CreatePlaylistInteractor implements CreatePlaylistInputBoundary {
    final CreatePlaylistDataAccessInterface playlistDataAccessObject;
    final CreatePlaylistOutputBoundary playlistPresenter;
    final PlaylistFactory playlistFactory;

    // Assuming that UserContext provides the current user's information

    public CreatePlaylistInteractor(CreatePlaylistDataAccessInterface playlistDataAccessInterface,
                                    CreatePlaylistOutputBoundary playlistOutputBoundary,
                                    PlaylistFactory playlistFactory) {
        this.playlistDataAccessObject = playlistDataAccessInterface;
        this.playlistPresenter = playlistOutputBoundary;
        this.playlistFactory = playlistFactory;
    }

    @Override
    public void execute(CreatePlaylistInputData createPlaylistInputData) throws IOException {

        LocalDateTime now = LocalDateTime.now();
        Playlist playlist = playlistFactory.create(createPlaylistInputData.getPlaylistName());
        playlist.setDate(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));

        if (playlistDataAccessObject.checkPlaylistExist("local", playlist.getName())) {
            playlistPresenter.prepareFailView("This playlist already exists.");
        } else {
            try {
                playlistDataAccessObject.createPlaylist("local", playlist);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            CreatePlaylistOutputData createPlaylistOutputData = new CreatePlaylistOutputData(playlist.getName(), now.toString());
            playlistPresenter.prepareSuccessView(createPlaylistOutputData);
        }
    }
}
