package app.gui;

import javax.swing.*;
import java.awt.*;

//import use_case.*;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Music Management System");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 600);

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

            frame.setLocationRelativeTo(null); // center the GUI

            frame.setVisible(true);
        });
    }

    private static JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // adding sub-panel for search box

        JTextField searchText = new JTextField(); // text input box
        searchText.setColumns(21); // width
        searchText.setBackground(Color.LIGHT_GRAY); // background color
        searchText.setForeground(Color.BLACK); // text color

        searchBoxPanel.add(searchText); // adding search box to sub-panel

        panel.add(searchBoxPanel, BorderLayout.NORTH);
        panel.setBackground(Color.WHITE);

        return panel;
    }

    private static JPanel createPlaylistPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel playlistLabel = new JLabel("Playlists Management Interface", SwingConstants.CENTER);
        playlistLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // text font & size
        panel.add(playlistLabel, BorderLayout.CENTER);

        panel.setBackground(Color.WHITE);
        return panel;
    }

    private static JPanel createSongPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel SonsLabel = new JLabel("Songs Management Interface", SwingConstants.CENTER);
        SonsLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // text font & size
        panel.add(SonsLabel, BorderLayout.CENTER);

        panel.setBackground(Color.WHITE);
        return panel;
    }
}
