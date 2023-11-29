package app;

import data_access.UserDatabaseDataAccessObject;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistPresenter;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import use_case.delete_playlist.DeletePlaylistInteractor;
import use_case.view_playlists.ViewPlaylistsInteractor;
import view.CreatePlaylistView;
import view.ViewPlaylistsView;
import interface_adapter.view_song.ViewSongController;
import interface_adapter.view_song.ViewSongPresenter;
import interface_adapter.view_song.ViewSongViewModel;
import use_case.view_song.ViewSongInteractor;
import view.ViewSongView;

import javax.swing.*;
import java.awt.*;

public class GUI_View_Playlists {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    public static void main(String[] args) {
        String storageDirectory = "src/database";
        UserDatabaseDataAccessObject dataAccess = new UserDatabaseDataAccessObject(storageDirectory);

        CreatePlaylistView createPlaylistView = CreatePlaylistUseCaseFactory.create(storageDirectory);

        // Set up for ViewPlaylists
        ViewPlaylistsViewModel playlistsViewModel = new ViewPlaylistsViewModel();
        ViewPlaylistsPresenter playlistsPresenter = new ViewPlaylistsPresenter(playlistsViewModel);
        ViewPlaylistsInteractor playlistsInteractor = new ViewPlaylistsInteractor(dataAccess, playlistsPresenter);
        ViewPlaylistsController playlistsController = new ViewPlaylistsController(playlistsInteractor);

        // Set up for ViewSongs
        ViewSongViewModel viewSongViewModel = new ViewSongViewModel();
        ViewSongPresenter viewSongPresenter = new ViewSongPresenter(viewSongViewModel);
        ViewSongInteractor viewSongInteractor = new ViewSongInteractor(dataAccess, viewSongPresenter);
        ViewSongController viewSongController = new ViewSongController(viewSongInteractor);

        DeletePlaylistViewModel deletePlaylistViewModel = new DeletePlaylistViewModel();
        DeletePlaylistPresenter deletePlaylistPresenter = new DeletePlaylistPresenter(deletePlaylistViewModel);
        DeletePlaylistInteractor deletePlaylistInteractor = new DeletePlaylistInteractor(dataAccess, deletePlaylistPresenter);
        DeletePlaylistController deletePlaylistController = new DeletePlaylistController(deletePlaylistInteractor);


        // Create the Views
        ViewPlaylistsView viewPlaylistsView = new ViewPlaylistsView(playlistsViewModel, playlistsController, viewSongController, deletePlaylistController);
        ViewSongView viewSongView = new ViewSongView(viewSongViewModel);

        // Set up the main application window
        JFrame frame = new JFrame("Playlist Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 300));

        // Set up card layout for view switching
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(viewPlaylistsView, "PlaylistsView");
        cardPanel.add(viewSongView, "SongView");
        cardPanel.add(createPlaylistView, "CreateView");
        frame.add(cardPanel);

        // Show the main window
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to switch to the song view
    public static void switchToSongView() {
        cardLayout.show(cardPanel, "SongView");
    }

    public static void switchToCreateView() {
        cardLayout.show(cardPanel,"CreateView");
    }
}
