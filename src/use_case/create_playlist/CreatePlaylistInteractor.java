package use_case.create_playlist;

import entity.Playlist;
import entity.PlaylistFactory;
import entity.UserDatabase;
import use_case.create_playlist.CreatePlaylistDataAccessInterface;
import use_case.create_playlist.CreatePlaylistInputData;
import use_case.create_playlist.CreatePlaylistOutputBoundary;

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
    public void execute(CreatePlaylistInputData createPlaylistInputData) {

        LocalDateTime now = LocalDateTime.now();
        Playlist playlist = playlistFactory.create(createPlaylistInputData.getPlaylistName());
        playlist.setDate(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
        playlistDataAccessObject.addPlaylist(playlist);

        CreatePlaylistOutputData createPlaylistOutputData = new CreatePlaylistOutputData(playlist.getName(), now.toString());
        playlistPresenter.prepareSuccessView(createPlaylistOutputData);
    }
}
