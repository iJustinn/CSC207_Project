package app;

import data_access.UserDatabaseDataAccessObject;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import use_case.view_playlists.ViewPlaylistsInteractor;
import view.ViewPlaylistsView;

import interface_adapter.view_song.ViewSongController;
import interface_adapter.view_song.ViewSongPresenter;
import interface_adapter.view_song.ViewSongViewModel;
import use_case.view_song.ViewSongInteractor;
import view.ViewSongView;

import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentPresenter;
import interface_adapter.update_comment.UpdateCommentViewModel;
import use_case.update_comment.UpdateCommentInteractor;
import view.UpdateCommentView;

import javax.swing.*;
import java.awt.*;

public class GUI_View_Playlists {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    public static void main(String[] args) {
        String storageDirectory = "src/database";
        UserDatabaseDataAccessObject dataAccess = new UserDatabaseDataAccessObject(storageDirectory);

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

        // Set up for UpdateComments
        UpdateCommentViewModel updateCommentViewModel = new UpdateCommentViewModel();
        UpdateCommentPresenter updateCommentPresenter = new UpdateCommentPresenter(updateCommentViewModel);
        UpdateCommentInteractor updateCommentInteractor = new UpdateCommentInteractor(dataAccess, updateCommentPresenter);
        UpdateCommentController updateCommentController = new UpdateCommentController(updateCommentInteractor);

        // Create the Views
        ViewPlaylistsView viewPlaylistsView = new ViewPlaylistsView(playlistsViewModel, playlistsController, viewSongController);
        ViewSongView viewSongView = new ViewSongView(viewSongViewModel, updateCommentController, updateCommentViewModel);

        // Set up the main application window
        JFrame frame = new JFrame("Playlist Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 300));

        // Set up card layout for view switching
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(viewPlaylistsView, "PlaylistsView");
        cardPanel.add(viewSongView, "SongView");

        // Add UpdateCommentView to the card layout
        UpdateCommentView updateCommentView = new UpdateCommentView(updateCommentViewModel, updateCommentController);
        cardPanel.add(updateCommentView, "UpdateCommentView");

        frame.add(cardPanel);

        // Show the main window
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to switch to the song view
    public static void switchToSongView() {
        cardLayout.show(cardPanel, "SongView");
    }

    // Method to switch back to the playlist view
    public static void switchToPlaylistView() {
        cardLayout.show(cardPanel, "PlaylistsView");
    }

    // Method to switch to the UpdateCommentView
    public static void switchToUpdateCommentView() {
        cardLayout.show(cardPanel, "UpdateCommentView");
    }
}
