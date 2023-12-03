package view;

import entity.song.Song;
import interface_adapter.add_song.AddSongController;
import interface_adapter.add_song.AddSongState;
import interface_adapter.add_song.AddSongViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongListView extends JPanel implements PropertyChangeListener {
    private JList<Song> songList;
    private JButton addButton;
    private AddSongController addSongController;
    private AddSongViewModel addSongViewModel;
    private ViewPlaylistsController viewPlaylistsController;
    private ViewPlaylistsViewModel viewPlaylistsViewModel;
    private List<String> playlists;

    public SongListView(JList<Song> songs,
                        AddSongController addSongController,
                        ViewPlaylistsController viewPlaylistsController,
                        ViewPlaylistsViewModel viewPlaylistsViewModel,
                        AddSongViewModel addSongViewModel) {
        this.addSongController = addSongController;
        this.viewPlaylistsController = viewPlaylistsController;
        this.viewPlaylistsViewModel = viewPlaylistsViewModel;
        this.addSongViewModel = addSongViewModel;
        this.viewPlaylistsViewModel.addPropertyChangeListener(this);
        this.addSongViewModel.addPropertyChangeListener(this);// Register as a listener
        this.songList = songs;
        initializeUI();

        try {
            viewPlaylistsController.execute("Alice");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadPlaylists();

    }

    // Initialize the UI with the existing songList JList
    private void initializeUI() {
        setLayout(new BorderLayout());
        // Add the songList JList wrapped in a JScrollPane to the center of the layout
        add(new JScrollPane(songList), BorderLayout.CENTER);

        // Initialize and add the addButton
        addButton = new JButton("Add to Playlist");
        addButton.addActionListener(this::onAddButtonClicked);
        add(addButton, BorderLayout.SOUTH);
    }

    private void onAddButtonClicked(ActionEvent e) {
        try {
            Song selectedSong = songList.getSelectedValue();
            if (selectedSong != null && !playlists.isEmpty()) {
                String selectedPlaylist = (String) JOptionPane.showInputDialog(
                        this, "Select a Playlist:", "Add Song to Playlist",
                        JOptionPane.QUESTION_MESSAGE, null,
                        playlists.toArray(new String[0]), playlists.get(0));

                if (selectedPlaylist != null && !selectedPlaylist.isEmpty()) {
                    addSongController.execute(selectedPlaylist, selectedSong);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a song first", "No Song Selected", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void loadPlaylists() {
        playlists = viewPlaylistsViewModel.getState().getPlaylists();
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("love story");
        if (playlists == null || playlists.isEmpty()) {
            playlists = new ArrayList<>();
            JOptionPane.showMessageDialog(this, "No playlists available.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == addSongViewModel) {
            AddSongState state = addSongViewModel.getState();
            if (state.getMessage() == "The song was successfully added.") {
                JOptionPane.showMessageDialog(this, state.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
                try {
                    viewPlaylistsController.execute("Alice"); // Refresh the playlists
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, state.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if ("state".equals(evt.getPropertyName())) {
            playlists = viewPlaylistsViewModel.getState().getPlaylists();
            if (playlists == null || playlists.isEmpty()) {
                playlists = new ArrayList<>();
                JOptionPane.showMessageDialog(this, "No playlists available.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private CustomListModel<Song> listModel;

    // Constructor and other methods...

    public void updateSongs(List<Song> songs) {
        listModel.setList(songs);
        listModel.fireDataChanged();
    }
}
