package app;

import javax.swing.*;
import java.awt.*;
import data_access.UserDatabaseDataAccessObject;
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreateViewModel;
import interface_adapter.ViewManagerModel;
import view.ViewManager;
import view.CreatePlaylistView;

public class GUI_create {
    public static void main(String[] args) {
        JFrame application = new JFrame("Playlist Application");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);


        CreatePlaylistView createPlaylistView = CreatePlaylistUseCaseFactory.create("src/database");
        views.add(createPlaylistView, createPlaylistView.viewName);

        // Set the initial view to CreatePlaylistView
        viewManagerModel.setActiveViewName(createPlaylistView.viewName);
        viewManagerModel.firePropertyChanged();

        // Display the application
        application.pack();
        application.setLocationRelativeTo(null); // Center the window
        application.setVisible(true);
    }
}
