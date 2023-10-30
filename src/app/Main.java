package app;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Media Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600); // Adjust as per your requirement
        frame.getContentPane().setBackground(Color.DARK_GRAY);

        // Top bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton recommendationsButton = new JButton("Recommendations");
        topBar.add(recommendationsButton);
        // Add user profile icon (using a placeholder button for now)
        JButton userProfileButton = new JButton("User Profile");
        topBar.add(userProfileButton);

        // Sidebar for playlists
        JPanel sidebar = new JPanel(new GridLayout(10, 1)); // Assuming 10 playlists max for simplicity
        sidebar.setBackground(Color.GRAY);
        sidebar.setPreferredSize(new Dimension(150, frame.getHeight()));

        for (int i = 0; i < 10; i++) { // Adding placeholder buttons for playlists
            JButton playlistButton = new JButton("Playlist " + (i + 1));
            sidebar.add(playlistButton);
        }

        // Central panel for recommended artists
        JPanel centerPanel = new JPanel(new GridLayout(2, 4)); // Assuming 8 recommended artists for simplicity
        centerPanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 8; i++) {
            JButton artistButton = new JButton("Artist " + (i + 1));
            centerPanel.add(artistButton);
        }

        frame.setLayout(new BorderLayout());
        frame.add(topBar, BorderLayout.NORTH);
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }
}
