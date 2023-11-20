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


public class Main {
    // Mostly copied from Week5 CACoding
    public static void main(String[] args) {
        JFrame application = new JFrame("Spotify");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SearchAlbumViewModel searchAlbumViewModel = new SearchAlbumViewModel();

        AlbumFactory albumFactory = new AlbumFactory();
        SpotifyEndpoint spotifyEndpoint = new SpotifyEndpoint();

        SpotifyDataAccessObject spotify = new SpotifyDataAccessObject(albumFactory, spotifyEndpoint);

        SearchView searchView = SearchAlbumUseCaseFactory.create(
                viewManagerModel,
                searchAlbumViewModel,
                spotify
        );
        views.add(searchView, searchView.viewName);

        viewManagerModel.setActiveViewName(searchView.viewName);
        viewManagerModel.firePropertyChanged();

        // Display the application
        application.pack();
        application.setVisible(true);
    }
}