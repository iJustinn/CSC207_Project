package app;

// Spotify API imports
import spotify.SpotifyEndpoint;
import data_access.SpotifyDataAccessObject;

// Views imports
import view.SearchView;
import view.ViewSongView;
import view.SearchAlbumView;
import view.ViewPlaylistsView;
import view.CreatePlaylistView;

// interface adapters imports
import interface_adapter.ViewManagerModel;
import data_access.UserDatabaseDataAccessObject;
import interface_adapter.view_song.ViewSongPresenter;
import interface_adapter.view_song.ViewSongViewModel;
import interface_adapter.view_song.ViewSongController;
import interface_adapter.delete_song.DeleteSongPresenter;
import interface_adapter.delete_song.DeleteSongViewModel;
import interface_adapter.delete_song.DeleteSongController;
import interface_adapter.search_album.SearchAlbumViewModel;
import interface_adapter.get_album_songs.GetSongsViewModel;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import interface_adapter.update_comment.UpdateCommentPresenter;
import interface_adapter.update_comment.UpdateCommentViewModel;
import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.delete_playlist.DeletePlaylistPresenter;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistController;

// use cases imports
import use_case.view_song.ViewSongInteractor;
import use_case.delete_song.DeleteSongInteractor;
import use_case.update_comment.UpdateCommentInteractor;
import use_case.view_playlists.ViewPlaylistsInteractor;
import use_case.delete_playlist.DeletePlaylistInteractor;

// JAVA swing imports
import java.awt.*;
import javax.swing.*;

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
            JPanel addPlaylistPanel = addPlaylistPanel();
            JPanel songSearchPanel = createSongSearchPanel();
            JPanel albumSearchPanel = createAlbumSearchPanel();
            JPanel artistSearchPanel = createArtistSearchPanel();

            // Adding panels to the card layout
            cardPanel.add(searchPanel, "SearchPanel");
            cardPanel.add(playlistPanel, "PlaylistPanel");
            cardPanel.add(songSearchPanel, "SongSearchPanel");
            cardPanel.add(albumSearchPanel, "AlbumSearchPanel");
            cardPanel.add(addPlaylistPanel, "addPlaylistPanel");
            cardPanel.add(artistSearchPanel, "ArtistSearchPanel");

            // Button panel (NOTE: order of code reflect order of buttons on the GUI)
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(createNavButton("Playlists", "PlaylistPanel"));
            buttonPanel.add(createNavButton("Search", "SearchPanel"));
            buttonPanel.add(createNavButton("Add", "addPlaylistPanel"));
            //            buttonPanel.add(createNavButton("Back", "SearchPanel"));

            // Adding panels to the frame
            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            // Styling
            buttonPanel.setBackground(Color.BLACK);
            frame.getContentPane().setBackground(Color.BLACK);

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

        JPanel buttonPanel_East = new JPanel();
        JPanel buttonPanel_West = new JPanel();
        JPanel buttonPanel_North = new JPanel();

        // Song button
        JButton songButton = createNavButton("Song", "SongSearchPanel");
        songButton.setPreferredSize(new Dimension(290, 50)); // button size
        songButton.setAlignmentX(Component.CENTER_ALIGNMENT); // button center alignment

        // Album button
        JButton albumButton = createNavButton("Album", "AlbumSearchPanel");
        albumButton.setPreferredSize(new Dimension(140, 50)); // button size
        albumButton.setAlignmentX(Component.CENTER_ALIGNMENT); // button center alignment

        // Artist button
        JButton artistButton = createNavButton("Artist", "ArtistSearchPanel");
        artistButton.setPreferredSize(new Dimension(140, 50)); // button size
        artistButton.setAlignmentX(Component.CENTER_ALIGNMENT); // button center alignment

        // adding buttons
        buttonPanel_North.add(songButton);
        buttonPanel_East.add(albumButton);
        buttonPanel_West.add(artistButton);

        panel.add(buttonPanel_East, BorderLayout.EAST);
        panel.add(buttonPanel_West, BorderLayout.WEST);
        panel.add(buttonPanel_North, BorderLayout.NORTH);

        panel.setBackground(Color.WHITE);

        return panel;
    }

    private static JPanel addPlaylistPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Initialize Database
        String storageDirectory = "src/database";

        // Initialize Views
        CreatePlaylistView createPlaylistView = CreatePlaylistUseCaseFactory.create(storageDirectory);

        // Add Views
        panel.add(createPlaylistView, BorderLayout.CENTER);

        return panel;
    }

    private static JPanel viewPlaylistPanel() {
        JPanel panel = new JPanel();

        JButton refreshButton = new JButton("Refresh");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        refreshButton.addActionListener(e -> refreshPlaylistsView());
        buttonPanel.add(refreshButton);

        // Initialize Database
        String storageDirectory = "src/database";
        UserDatabaseDataAccessObject dataAccess = new UserDatabaseDataAccessObject(storageDirectory);

        // Setups
        ViewSongViewModel viewSongViewModel = new ViewSongViewModel();
        DeleteSongViewModel deleteSongViewModel = new DeleteSongViewModel();
        ViewPlaylistsViewModel playlistsViewModel = new ViewPlaylistsViewModel();
        UpdateCommentViewModel updateCommentViewModel = new UpdateCommentViewModel();
        DeletePlaylistViewModel deletePlaylistViewModel = new DeletePlaylistViewModel();

        ViewSongPresenter viewSongPresenter = new ViewSongPresenter(viewSongViewModel);
        DeleteSongPresenter deleteSongPresenter = new DeleteSongPresenter(deleteSongViewModel);
        ViewPlaylistsPresenter playlistsPresenter = new ViewPlaylistsPresenter(playlistsViewModel);
        UpdateCommentPresenter updateCommentPresenter = new UpdateCommentPresenter(updateCommentViewModel);
        DeletePlaylistPresenter deletePlaylistPresenter = new DeletePlaylistPresenter(deletePlaylistViewModel);

        ViewSongInteractor viewSongInteractor = new ViewSongInteractor(dataAccess, viewSongPresenter);
        DeleteSongInteractor deleteSongInteractor = new DeleteSongInteractor(dataAccess, deleteSongPresenter);
        ViewPlaylistsInteractor playlistsInteractor = new ViewPlaylistsInteractor(dataAccess, playlistsPresenter);
        UpdateCommentInteractor updateCommentInteractor = new UpdateCommentInteractor(dataAccess, updateCommentPresenter);
        DeletePlaylistInteractor deletePlaylistInteractor = new DeletePlaylistInteractor(dataAccess, deletePlaylistPresenter);

        ViewSongController viewSongController = new ViewSongController(viewSongInteractor);
        DeleteSongController deleteSongController = new DeleteSongController(deleteSongInteractor);
        ViewPlaylistsController playlistsController = new ViewPlaylistsController(playlistsInteractor);
        UpdateCommentController updateCommentController = new UpdateCommentController(updateCommentInteractor);
        DeletePlaylistController deletePlaylistController = new DeletePlaylistController(deletePlaylistInteractor);

        // Initialize Views
        ViewPlaylistsView viewPlaylistsView = new ViewPlaylistsView(playlistsViewModel, playlistsController, viewSongController, deletePlaylistController, deletePlaylistViewModel);
        ViewSongView viewSongView = new ViewSongView(viewSongViewModel, updateCommentController, updateCommentViewModel, deleteSongController, deleteSongViewModel, viewSongController);

        // Add Views
        panel.add(viewPlaylistsView, BorderLayout.NORTH);
        panel.add(viewSongView, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void switchToSongView() {
        cardLayout.show(cardPanel, "PlaylistPanel"); // show PlaylistPanel
    }

    public static void switchToCreateView() {
        cardLayout.show(cardPanel, "addPlaylistPanel"); // show addPlaylistPanel
    }

    private static void refreshPlaylistsView() { // refresh playlist
        // not sure how to do this :(
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

        GetSongsViewModel getSongsViewModel = new GetSongsViewModel();

        SearchAlbumView searchAlbumView = SearchUseCaseFactory.create(
                viewManagerModel,
                searchAlbumViewModel,
                spotify,
                getSongsViewModel,
                spotify
        );

        panel.add(searchAlbumView, BorderLayout.CENTER);

        return panel;
    }

    private static JPanel createArtistSearchPanel() {
        JPanel panel = new JPanel();

        // Add components for artist search

        return panel;
    }
}
