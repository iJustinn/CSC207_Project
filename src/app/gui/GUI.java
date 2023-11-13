package app.gui;

import javax.swing.*;
import java.awt.*;

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
            JPanel searchPanel = createSearchPanel(cardLayout, cardPanel);
            JPanel playlistPanel = createPlaylistPanel();
//            JPanel songPanel = createSongPanel();
            JPanel songSearchPanel = createSongSearchPanel();
            JPanel albumSearchPanel = createAlbumSearchPanel();
            JPanel artistSearchPanel = createArtistSearchPanel();

            // Adding panels to the card layout
            cardPanel.add(searchPanel, "SearchPanel");
            cardPanel.add(playlistPanel, "PlaylistPanel");
//            cardPanel.add(songPanel, "SongPanel");
            cardPanel.add(songSearchPanel, "SongSearchPanel");
            cardPanel.add(albumSearchPanel, "AlbumSearchPanel");
            cardPanel.add(artistSearchPanel, "ArtistSearchPanel");

            // Button panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(new JButton("Search") {{
                setForeground(Color.BLACK);
                addActionListener(e -> cardLayout.show(cardPanel, "SearchPanel"));
            }});
            buttonPanel.add(new JButton("Playlists") {{
                setForeground(Color.BLACK);
                addActionListener(e -> cardLayout.show(cardPanel, "PlaylistPanel"));
            }});
//            buttonPanel.add(new JButton("Songs") {{
//                setForeground(Color.BLACK);
//                addActionListener(e -> cardLayout.show(cardPanel, "SongPanel"));
//            }});

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

    private static JPanel createSearchPanel(CardLayout cardLayout, JPanel cardPanel) {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // adding sub-panel for search box

        JTextField searchText = new JTextField(); // text input box
        searchText.setColumns(21); // width
        searchText.setBackground(Color.LIGHT_GRAY); // background color
        searchText.setForeground(Color.BLACK); // text color

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(new JButton("Song") {{
            addActionListener(e -> cardLayout.show(cardPanel, "SongSearchPanel"));
        }});
        buttonPanel.add(new JButton("Album") {{
            addActionListener(e -> cardLayout.show(cardPanel, "AlbumSearchPanel"));
        }});
        buttonPanel.add(new JButton("Artist") {{
            addActionListener(e -> cardLayout.show(cardPanel, "ArtistSearchPanel"));
        }});

        searchBoxPanel.add(searchText); // adding search box to sub-panel
        panel.add(searchBoxPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

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

//    private static JPanel createSongPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//
//        JLabel SonsLabel = new JLabel("Songs Management Interface", SwingConstants.CENTER);
//        SonsLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // text font & size
//        panel.add(SonsLabel, BorderLayout.CENTER);
//
//        panel.setBackground(Color.WHITE);
//        return panel;
//    }

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