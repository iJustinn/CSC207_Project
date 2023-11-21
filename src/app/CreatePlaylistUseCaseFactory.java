package app;

import data_access.UserDatabaseDataAccessObject;
import entity.Playlist.PlaylistFactory;
import interface_adapter.create_playlist.CreatePlaylistPresenter;
import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInteractor; // Include the CreatePlaylistInteractor
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreateViewModel;
import use_case.create_playlist.CreatePlaylistOutputBoundary;
import view.CreatePlaylistView;

public class CreatePlaylistUseCaseFactory {

    public static CreatePlaylistView create(String storageDirectory) {

        PlaylistFactory playlistFactory = new PlaylistFactory();
        UserDatabaseDataAccessObject userDatabaseDao = new UserDatabaseDataAccessObject(storageDirectory);


        CreateViewModel createPlaylistViewModel = new CreateViewModel();

        CreatePlaylistOutputBoundary outputBoundary = new CreatePlaylistPresenter(createPlaylistViewModel);

        CreatePlaylistInputBoundary inputBoundary = new CreatePlaylistInteractor(userDatabaseDao, outputBoundary,playlistFactory);


        CreatePlaylistController createPlaylistController = new CreatePlaylistController(inputBoundary);


        return new CreatePlaylistView(createPlaylistViewModel, createPlaylistController);
    }
}
