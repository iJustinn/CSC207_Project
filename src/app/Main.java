package app;

// Spotify API imports
import spotify.SpotifyEndpoint;
import data_access.SpotifyDataAccessObject;

// Views imports
import view.SearchView;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_album.SearchAlbumViewModel;

// tempo
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

// JAVA swing imports
import javax.swing.*;
import java.awt.*;

public class Main {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;
    private static ViewManagerModel viewManagerModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Music Management System"); // name of the window
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 600); // size of the window

            // Initialize ViewManagerModel
            viewManagerModel = new ViewManagerModel();

            // CardLayout for switching between different panels
            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);

            // All panels in the program
            JPanel searchPanel = createSearchPanel();
            JPanel playlistPanel = viewPlaylistPanel();
            JPanel songSearchPanel = createSongSearchPanel();
            JPanel albumSearchPanel = createAlbumSearchPanel();
            JPanel artistSearchPanel = createArtistSearchPanel();
            JPanel addPlaylistPanel = addPlaylistPanel();

            // Adding panels to the card layout
            cardPanel.add(searchPanel, "SearchPanel");
            cardPanel.add(playlistPanel, "PlaylistPanel");
            cardPanel.add(songSearchPanel, "SongSearchPanel");
            cardPanel.add(albumSearchPanel, "AlbumSearchPanel");
            cardPanel.add(artistSearchPanel, "ArtistSearchPanel");
            cardPanel.add(addPlaylistPanel, "addPlaylistPanel");

            // Button panel, order of code reflect order on the program window
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(createNavButton("Playlists", "PlaylistPanel"));
            buttonPanel.add(createNavButton("Search", "SearchPanel"));
            buttonPanel.add(createNavButton("Add", "addPlaylistPanel"));
            //            buttonPanel.add(createNavButton("Back", "SearchPanel"));

            // Adding panels to the frame
            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            // Styling
            frame.getContentPane().setBackground(Color.BLACK);
            buttonPanel.setBackground(Color.BLACK);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JButton createNavButton(String name, String panelName) {
        JButton button = new JButton(name);
        button.setForeground(Color.BLACK);
        button.addActionListener(e -> cardLayout.show(cardPanel, panelName));
        return button;
    }

    private static JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttonPanel_North = new JPanel();
        JPanel buttonPanel_East = new JPanel();
        JPanel buttonPanel_West = new JPanel();

        // Song button
        JButton songButton = createNavButton("Song", "SongSearchPanel");
        songButton.setPreferredSize(new Dimension(150, 50)); // button size
        songButton.setAlignmentX(Component.CENTER_ALIGNMENT); // button center alignment

        // Album button
        JButton albumButton = createNavButton("Album", "AlbumSearchPanel");
        albumButton.setPreferredSize(new Dimension(150, 50)); // button size
        albumButton.setAlignmentX(Component.CENTER_ALIGNMENT); // button center alignment

        // Artist button
        JButton artistButton = createNavButton("Artist", "ArtistSearchPanel");
        artistButton.setPreferredSize(new Dimension(150, 50)); // button size
        artistButton.setAlignmentX(Component.CENTER_ALIGNMENT); // button center alignment

        // adding buttons
        buttonPanel_North.add(songButton);
        buttonPanel_East.add(albumButton);
        buttonPanel_West.add(artistButton);

        panel.add(buttonPanel_North, BorderLayout.NORTH);
        panel.add(buttonPanel_East, BorderLayout.EAST);
        panel.add(buttonPanel_West, BorderLayout.WEST);

        panel.setBackground(Color.WHITE);

        return panel;
    }

    private static JPanel addPlaylistPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Initialize Database
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

        panel.add(createPlaylistView, BorderLayout.CENTER);

        return panel;
    }

        private static JPanel viewPlaylistPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Initialize Database
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

        panel.add(viewPlaylistsView, BorderLayout.NORTH);
        panel.add(viewSongView, BorderLayout.CENTER);
//        panel.add(createPlaylistView, BorderLayout.SOUTH);

//        cardPanel.add(viewPlaylistsView, "PlaylistsView");
//        cardPanel.add(viewSongView, "SongView");
//        cardPanel.add(createPlaylistView, "CreateView");
//        panel.add(cardPanel);

        return panel;
    }

    public static void switchToSongView() {
        cardLayout.show(cardPanel, "SongView");
    }

    public static void switchToCreateView() {
        cardLayout.show(cardPanel, "CreateView");
    }

    private static JPanel createSongSearchPanel() {
        JPanel panel = new JPanel();

        // Add components for song search

        return panel;
    }

    private static JPanel createAlbumSearchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        SearchAlbumViewModel searchAlbumViewModel = new SearchAlbumViewModel();
        SpotifyEndpoint spotifyEndpoint = new SpotifyEndpoint();
        SpotifyDataAccessObject spotify = new SpotifyDataAccessObject(spotifyEndpoint);

        SearchView searchView = SearchAlbumUseCaseFactory.create(
                viewManagerModel,
                searchAlbumViewModel,
                spotify
        );

        panel.add(searchView, BorderLayout.CENTER);

        return panel;
    }

    private static JPanel createArtistSearchPanel() {
        JPanel panel = new JPanel();

        // Add components for artist search

        return panel;
    }
}
