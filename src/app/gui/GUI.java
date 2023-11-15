package app.gui;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private static JButton backButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Music Management System"); // name of the window
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 600); // size of the window

            // CardLayout for switching between different panels
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            // Panels for main (search) and playlist
            JPanel searchPanel = createSearchPanel(cardLayout, cardPanel);
            JPanel playlistPanel = createPlaylistPanel();
            // Panels for three types of search
            JPanel songSearchPanel = createSongSearchPanel();
            JPanel albumSearchPanel = createAlbumSearchPanel();
            JPanel artistSearchPanel = createArtistSearchPanel();

            // Adding panels to the card layout
            cardPanel.add(searchPanel, "SearchPanel");
            cardPanel.add(playlistPanel, "PlaylistPanel");
            cardPanel.add(songSearchPanel, "SongSearchPanel");
            cardPanel.add(albumSearchPanel, "AlbumSearchPanel");
            cardPanel.add(artistSearchPanel, "ArtistSearchPanel");

            // Button panel
            JPanel buttonPanel = new JPanel();
//            buttonPanel.add(createNavButton("Back", "SearchPanel", cardLayout, cardPanel, buttonPanel));
            buttonPanel.add(createNavButton("Playlists", "PlaylistPanel", cardLayout, cardPanel, buttonPanel));
            buttonPanel.add(createNavButton("Search", "SearchPanel", cardLayout, cardPanel, buttonPanel));
            // Back button
            backButton = createNavButton("Back", "SearchPanel", cardLayout, cardPanel, buttonPanel);
//            backButton.setVisible(false); // Initially invisible
            buttonPanel.add(backButton);

            // Adding panels to the frame
            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            // Styling
            frame.getContentPane().setBackground(Color.BLACK);
            buttonPanel.setBackground(Color.BLACK);

            frame.setLocationRelativeTo(null); // center the GUI
            frame.setVisible(true);
        });
    }

    private static JButton createNavButton(String name, String panelName, CardLayout cardLayout, JPanel cardPanel, JPanel buttonPanel) {
        JButton button = new JButton(name);
        button.setForeground(Color.BLACK);
        button.addActionListener(e -> {
            cardLayout.show(cardPanel, panelName);
//            updateBackButtonVisibility(buttonPanel, name);
        });
        return button;
    }

//    private static void updateBackButtonVisibility(JPanel buttonPanel, String buttonName) {
//        // Show the Back button only when not on the main Search panel
//        backButton.setVisible(!"Search".equals(buttonName));
////        backButton.setVisible(!"Playlists".equals(buttonName));
//    }

    private static JPanel createSearchPanel(CardLayout cardLayout, JPanel cardPanel) {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // adding sub-panel for search box
        JTextField searchText = new JTextField(); // text input box
        searchText.setColumns(21); // width
        searchText.setBackground(Color.LIGHT_GRAY); // background color
        searchText.setForeground(Color.BLACK); // text color

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(createNavButton("Song", "SongSearchPanel", cardLayout, cardPanel, buttonPanel));
        buttonPanel.add(createNavButton("Album", "AlbumSearchPanel", cardLayout, cardPanel, buttonPanel));
        buttonPanel.add(createNavButton("Artist", "ArtistSearchPanel", cardLayout, cardPanel, buttonPanel));

        searchBoxPanel.add(searchText); // adding search box to sub-panel
        panel.add(searchBoxPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        panel.setBackground(Color.WHITE);
        return panel;
    }

    private static JPanel createPlaylistPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel playlistLabel = new JLabel("Playlists Management Interface", SwingConstants.CENTER);
        playlistLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // text font & size
        panel.add(playlistLabel, BorderLayout.CENTER);

        panel.setBackground(Color.WHITE);
        return panel;
    }

    private static JPanel createSongSearchPanel() {
        JPanel panel = new JPanel();
        // Customize this panel for song search
        return panel;
    }

    private static JPanel createAlbumSearchPanel() {
        JPanel panel = new JPanel();
        // Customize this panel for album search
        return panel;
    }

    private static JPanel createArtistSearchPanel() {
        JPanel panel = new JPanel();
        // Customize this panel for artist search
        return panel;
    }
}

// cd ~/Library/CloudStorage/Dropbox/Code/CSC207/CSC207_Project
// javac -d bin src/app/gui/GUI.java
// java -cp bin app.gui.GUI