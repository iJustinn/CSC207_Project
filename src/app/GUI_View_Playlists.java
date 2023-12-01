package app;

import data_access.UserDatabaseDataAccessObject;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistPresenter;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.delete_song.DeleteSongController;
import interface_adapter.delete_song.DeleteSongPresenter;
import interface_adapter.delete_song.DeleteSongViewModel;
import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentPresenter;
import interface_adapter.update_comment.UpdateCommentViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import use_case.delete_playlist.DeletePlaylistInteractor;
import use_case.delete_song.DeleteSongInteractor;
import use_case.update_comment.UpdateCommentInteractor;
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

        // Set up for DeletePlaylist
        DeletePlaylistViewModel deletePlaylistViewModel = new DeletePlaylistViewModel();
        DeletePlaylistPresenter deletePlaylistPresenter = new DeletePlaylistPresenter(deletePlaylistViewModel);
        DeletePlaylistInteractor deletePlaylistInteractor = new DeletePlaylistInteractor(dataAccess, deletePlaylistPresenter);
        DeletePlaylistController deletePlaylistController = new DeletePlaylistController(deletePlaylistInteractor);

        // Set up for UpdateComments
        UpdateCommentViewModel updateCommentViewModel = new UpdateCommentViewModel();
        UpdateCommentPresenter updateCommentPresenter = new UpdateCommentPresenter(updateCommentViewModel);
        UpdateCommentInteractor updateCommentInteractor = new UpdateCommentInteractor(dataAccess, updateCommentPresenter);
        UpdateCommentController updateCommentController = new UpdateCommentController(updateCommentInteractor);

        // Set up for DeleteSongs
        DeleteSongViewModel deleteSongViewModel = new DeleteSongViewModel();
        DeleteSongPresenter deleteSongPresenter = new DeleteSongPresenter(deleteSongViewModel);
        DeleteSongInteractor deleteSongInteractor = new DeleteSongInteractor(dataAccess, deleteSongPresenter);
        DeleteSongController deleteSongController = new DeleteSongController(deleteSongInteractor);


        // Create the Views
        ViewPlaylistsView viewPlaylistsView = new ViewPlaylistsView(playlistsViewModel, playlistsController, viewSongController, deletePlaylistController, deletePlaylistViewModel);
        ViewSongView viewSongView = new ViewSongView(viewSongViewModel, updateCommentController, updateCommentViewModel, deleteSongController, deleteSongViewModel, viewSongController);

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

//    // Method to switch to the song view
//    public static void switchToSongView() {
//        cardLayout.show(cardPanel, "SongView");
//    }
//    // Method to switch to the Createview
//    public static void switchToCreateView() {
//        cardLayout.show(cardPanel,"CreateView");
//    }
//    // Method to switch to the UpdateCommentView
//    public static void switchToUpdateCommentView() {
//        cardLayout.show(cardPanel, "UpdateCommentView");
//    }

}
