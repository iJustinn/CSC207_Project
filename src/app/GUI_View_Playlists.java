package app;

import data_access.UserDatabaseDataAccessObject;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import use_case.view_playlists.ViewPlaylistsDataUserAccessInterface;
import use_case.view_playlists.ViewPlaylistsInteractor;
import view.ViewPlaylistsView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Main class to run the application
public class GUI_View_Playlists {

    public static void main(String[] args) {
        // Set up the components
        ViewPlaylistsViewModel viewModel = new ViewPlaylistsViewModel();
        ViewPlaylistsPresenter presenter = new ViewPlaylistsPresenter(viewModel);

        // Set the storage directory to the 'database' folder within the 'src' directory
        String storageDirectory = "src/database";
        UserDatabaseDataAccessObject dataAccess = new UserDatabaseDataAccessObject(storageDirectory);

        ViewPlaylistsInteractor interactor = new ViewPlaylistsInteractor(dataAccess, presenter);
        ViewPlaylistsController controller = new ViewPlaylistsController(interactor);
        ViewPlaylistsView view = new ViewPlaylistsView(viewModel);


        // Set up the main window (JFrame)
        JFrame frame = new JFrame("Playlist Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 300));
        frame.add(view);

        // Show the window
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);

        // Trigger the display of playlists for user "Alice"
        SwingUtilities.invokeLater(() -> {
            try {
                // The execute method should now specifically load Alice's playlists
                controller.execute("Alice"); // Pass "Alice" as the username to load the correct playlists
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error loading playlists: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
