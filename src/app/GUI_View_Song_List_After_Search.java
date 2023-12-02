package app;

import data_access.UserDatabaseDataAccessObject;
import entity.song.Song;
import interface_adapter.add_song.AddSongController;
import interface_adapter.add_song.AddSongPresenter;
import interface_adapter.add_song.AddSongViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsPresenter;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import use_case.add_song.AddSongInteractor;
import use_case.view_playlists.ViewPlaylistsInteractor;
import view.SongListView;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI_View_Song_List_After_Search {
    public static void main(String[] args) throws IOException {
        // Initialize Data Access Object
        UserDatabaseDataAccessObject dataAccessObject = new UserDatabaseDataAccessObject("path/to/your/storageDirectory");

        // Initialize View Models
        AddSongViewModel addSongViewModel = new AddSongViewModel();
        ViewPlaylistsViewModel viewPlaylistsViewModel = new ViewPlaylistsViewModel();

        // Initialize Presenters
        AddSongPresenter addSongPresenter = new AddSongPresenter(addSongViewModel);
        ViewPlaylistsPresenter viewPlaylistsPresenter = new ViewPlaylistsPresenter(viewPlaylistsViewModel);

        // Initialize Interactors
        AddSongInteractor addSongInteractor = new AddSongInteractor(dataAccessObject, addSongPresenter);
        ViewPlaylistsInteractor viewPlaylistsInteractor = new ViewPlaylistsInteractor(dataAccessObject, viewPlaylistsPresenter);

        // Initialize Controllers
        AddSongController addSongController = new AddSongController(addSongInteractor);
        ViewPlaylistsController viewPlaylistsController = new ViewPlaylistsController(viewPlaylistsInteractor);

        ));
        // Fetch Playlists and Update ViewModel
        viewPlaylistsController.execute("Alice");

        // Create the SongListView
        List<Song> songs = new ArrayList<>(Arrays.asList(
                new Song("Song Title 1", new ArrayList<>(Arrays.asList("Artist A")), "Album 1", "1"),
                new Song("Song Title 2", new ArrayList<>(Arrays.asList("Artist B")), "Album 2", "2")


        JFrame frame = new JFrame("Playlist Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(songListView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    }
}
