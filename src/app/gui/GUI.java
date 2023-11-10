package app.gui;

import javax.swing.*;
import java.awt.*;

import use_case.*;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Music Management System");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(1000, 500);

            // CardLayout for switching between different panels
            CardLayout cardLayout = new CardLayout();
            JPanel cardPanel = new JPanel(cardLayout);

            // Panels for different functionalities
            JPanel searchPanel = createSearchPanel();
            JPanel playlistPanel = createPlaylistPanel();
            JPanel songPanel = createSongPanel();

            // Adding panels to the card layout
            cardPanel.add(searchPanel, "SearchPanel");
            cardPanel.add(playlistPanel, "PlaylistPanel");
            cardPanel.add(songPanel, "SongPanel");

            // Buttons for switching between panels
            JButton searchButton = new JButton("Search");
            searchButton.setForeground(Color.BLACK);
            searchButton.addActionListener(e -> cardLayout.show(cardPanel, "SearchPanel"));

            JButton playlistButton = new JButton("Playlists");
            playlistButton.setForeground(Color.BLACK);
            playlistButton.addActionListener(e -> cardLayout.show(cardPanel, "PlaylistPanel"));

            JButton songButton = new JButton("Songs");
            songButton.setForeground(Color.BLACK);
            songButton.addActionListener(e -> cardLayout.show(cardPanel, "SongPanel"));

            // Button panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(searchButton);
            buttonPanel.add(playlistButton);
            buttonPanel.add(songButton);

            // Adding panels to the frame
            frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            // Styling
            frame.getContentPane().setBackground(Color.BLACK);
            buttonPanel.setBackground(Color.BLACK);

            frame.setVisible(true);
        });
    }

    private static JPanel createSearchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        // Add components for search functionality
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private static JPanel createPlaylistPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        // Add components for playlist management
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private static JPanel createSongPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        // Add components for song management
        panel.setBackground(Color.WHITE);
        return panel;
    }
}
