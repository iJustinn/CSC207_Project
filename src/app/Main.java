package app;

import data_access.SpotifyDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.search_album.SearchAlbumViewModel;
import view.SearchView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    // Mostly copied from Week5 CACoding
    private static void createAndShowGUI() {
        // Create a frame
        JFrame frame = new JFrame("Spotify");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        frame.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SearchAlbumViewModel searchAlbumViewModel = new SearchAlbumViewModel();

        SpotifyDataAccessObject spotify;
        try {
            spotify = new SpotifyDataAccessObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SearchView searchView = SearchAlbumUseCaseFactory.create(
                viewManagerModel,
                searchAlbumViewModel,
                spotify
        );

        views.add(searchView, searchView.viewName);
        viewManagerModel.setActiveViewName(searchView.viewName);
        viewManagerModel.firePropertyChanged();

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }
}