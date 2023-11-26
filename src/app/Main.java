package app;

import data_access.SpotifyDataAccessObject;
import entity.album.AlbumFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_album.SearchAlbumViewModel;
import spotify.SpotifyEndpoint;
import view.SearchView;
import view.ViewManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            JPanel playlistPanel = createPlaylistPanel();
            JPanel songSearchPanel = createSongSearchPanel();
            JPanel albumSearchPanel = createAlbumSearchPanel();
            JPanel artistSearchPanel = createArtistSearchPanel();
            JPanel specificPlaylistPanel = createSpecificPlaylistPanel();

            // Adding panels to the card layout
            cardPanel.add(searchPanel, "SearchPanel");
            cardPanel.add(playlistPanel, "PlaylistPanel");
            cardPanel.add(songSearchPanel, "SongSearchPanel");
            cardPanel.add(albumSearchPanel, "AlbumSearchPanel");
            cardPanel.add(artistSearchPanel, "ArtistSearchPanel");
            cardPanel.add(specificPlaylistPanel, "SpecificPlaylistPanel");

            // Button panel, order of code reflect order on the program window
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(createNavButton("Playlists", "PlaylistPanel"));
            buttonPanel.add(createNavButton("Search", "SearchPanel"));
            buttonPanel.add(createNavButton("Back", "SearchPanel"));

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

        JPanel searchBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField searchText = new JTextField();
        searchText.setColumns(21);
        searchText.setBackground(Color.LIGHT_GRAY);
        searchText.setForeground(Color.BLACK);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(createNavButton("Song", "SongSearchPanel"));
        buttonPanel.add(createNavButton("Album", "AlbumSearchPanel"));
        buttonPanel.add(createNavButton("Artist", "ArtistSearchPanel"));

        searchBoxPanel.add(searchText);
        panel.add(searchBoxPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        panel.setBackground(Color.WHITE);
        return panel;
    }

    public interface PlaylistAccessListener {
        void onPlaylistAccess(String playlistName);
    }

    private static JPanel createPlaylistPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] playlists = {"Playlist EX #1", "Playlist EX #2"};

        PlaylistAccessListener listener = new PlaylistAccessListener() {
            @Override
            public void onPlaylistAccess(String playlistName) {
                System.out.println("Accessing playlist: " + playlistName);
                cardLayout.show(cardPanel, "SpecificPlaylistPanel");
            }
        };

        JList<String> playlistList = new JList<>(playlists);
        playlistList.setCellRenderer(new PlaylistCellRenderer(listener));
        JScrollPane scrollPane = new JScrollPane(playlistList);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    static class PlaylistCellRenderer extends JPanel implements ListCellRenderer<String> {
        private JLabel nameLabel;
        private JButton accessButton;
        private PlaylistAccessListener listener;

        public PlaylistCellRenderer(PlaylistAccessListener listener) {
            this.listener = listener;
            setLayout(new BorderLayout());
            nameLabel = new JLabel();
            accessButton = new JButton("Access");
            accessButton.addActionListener(e -> {
                if (listener != null) {
                    listener.onPlaylistAccess(nameLabel.getText());
                }
            });
            add(nameLabel, BorderLayout.CENTER);
            add(accessButton, BorderLayout.EAST);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText(value);
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }

        private void accessPlaylist(String playlistName) {
            cardLayout.show(cardPanel, "SpecificPlaylistPanel");
            cardPanel.revalidate();
            cardPanel.repaint();
        }
    }

    private static JPanel createSpecificPlaylistPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Playlist Interface TO BE IMPLEMENT"));
        panel.setBackground(Color.WHITE); // Distinctive color for testing
        return panel;
    }

//    public static class ButtonRenderer extends JButton implements TableCellRenderer {
//        public ButtonRenderer() {
//            setOpaque(true);
//        }
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value,
//                                                       boolean isSelected, boolean hasFocus, int row, int column) {
//            setText((value == null) ? "" : value.toString());
//            return this;
//        }
//    }

    public static class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    isPushed = true;
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // Switch to the specific playlist panel
                cardLayout.show(cardPanel, "SpecificPlaylistPanel");
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
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
        AlbumFactory albumFactory = new AlbumFactory();
        SpotifyEndpoint spotifyEndpoint = new SpotifyEndpoint();
        SpotifyDataAccessObject spotify = new SpotifyDataAccessObject(albumFactory, spotifyEndpoint);

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
