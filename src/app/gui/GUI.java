package app.gui;

import app.SearchAlbumUseCaseFactory;
import data_access.SpotifyDataAccessObject;
import entity.album.AlbumFactory;
import interface_adapter.search_album.SearchAlbumViewModel;
import view.SearchView;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Music Management System"); // name of the window
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 600); // size of the window

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
        buttonPanel.add(createNavButton("entity/song", "SongSearchPanel"));
        buttonPanel.add(createNavButton("Album", "AlbumSearchPanel"));
        buttonPanel.add(createNavButton("Artist", "ArtistSearchPanel"));

        searchBoxPanel.add(searchText);
        panel.add(searchBoxPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        panel.setBackground(Color.WHITE);
        return panel;
    }

    private static JPanel createPlaylistPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"entity/Playlist", "Access"};
        Object[][] data = {
                {"Playlist EX #1", "Access"},
                {"Playlist EX #2", "Access"},
                // Dummy Variables for now
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return column == 1;
            }
        };
        JTable table = new JTable(model);

        TableColumn accessColumn = table.getColumnModel().getColumn(1);
        accessColumn.setCellRenderer(new ButtonRenderer());
        accessColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private static JPanel createSpecificPlaylistPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Specific Playlist Interface"));
        panel.setBackground(Color.WHITE);
        return panel;
    }

    public static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

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
        // Add components for album search

//        SearchAlbumViewModel searchAlbumViewModel = new SearchAlbumViewModel();
//
//        AlbumFactory albumFactory = new AlbumFactory();
//        SpotifyEndpoint spotifyEndpoint = new SpotifyEndpoint();
//
//        SpotifyDataAccessObject spotify = new SpotifyDataAccessObject(albumFactory, spotifyEndpoint);
//
//        SearchView searchView = SearchAlbumUseCaseFactory.create(
//                viewManagerModel,
//                searchAlbumViewModel,
//                spotify
//        );
//        views.add(searchView, searchView.viewName);
//
//        viewManagerModel.setActiveViewName(searchView.viewName);
//        viewManagerModel.firePropertyChanged();

        return panel;
    }

    private static JPanel createArtistSearchPanel() {
        JPanel panel = new JPanel();
        // Add components for artist search
        return panel;
    }
}
