package app;

import data_access.UserDatabaseDataAccessObject;
import entity.Playlist.PlaylistFactory;
import interface_adapter.create_playlist.CreatePlaylistPresenter;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import use_case.create_playlist.CreatePlaylistInputBoundary;
import use_case.create_playlist.CreatePlaylistInteractor; // Include the CreatePlaylistInteractor
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreateViewModel;
import use_case.create_playlist.CreatePlaylistOutputBoundary;
import use_case.view_playlists.ViewPlaylistsInteractor;
import view.CreatePlaylistView;

public class CreatePlaylistUseCaseFactory {

    public static CreatePlaylistView create(String storageDirectory) {



        PlaylistFactory playlistFactory = new PlaylistFactory();
        UserDatabaseDataAccessObject userDatabaseDao = new UserDatabaseDataAccessObject(storageDirectory);

        // Set up for ViewPlaylists
        ViewPlaylistsViewModel playlistsViewModel = new ViewPlaylistsViewModel();
        ViewPlaylistsPresenter playlistsPresenter = new ViewPlaylistsPresenter(playlistsViewModel);
        ViewPlaylistsInteractor playlistsInteractor = new ViewPlaylistsInteractor(userDatabaseDao, playlistsPresenter);
        ViewPlaylistsController playlistsController = new ViewPlaylistsController(playlistsInteractor);


        CreateViewModel createPlaylistViewModel = new CreateViewModel();

        CreatePlaylistOutputBoundary outputBoundary = new CreatePlaylistPresenter(createPlaylistViewModel);

        CreatePlaylistInputBoundary inputBoundary = new CreatePlaylistInteractor(userDatabaseDao, outputBoundary,playlistFactory);


        CreatePlaylistController createPlaylistController = new CreatePlaylistController(inputBoundary);


        return new CreatePlaylistView(createPlaylistViewModel, createPlaylistController, playlistsController);
    }
}
