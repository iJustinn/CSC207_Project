package view;

import entity.song.Song;
import interface_adapter.add_song.AddSongController;
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

    public SongListView(List<Song> songs, AddSongController addSongController,
                        ViewPlaylistsController viewPlaylistsController,
                        ViewPlaylistsViewModel viewPlaylistsViewModel) {
        this.addSongController = addSongController;
        this.viewPlaylistsController = viewPlaylistsController;
        this.viewPlaylistsViewModel = viewPlaylistsViewModel;
        this.viewPlaylistsViewModel.addPropertyChangeListener(this); // Register as a listener

        initializeUI(songs);

        try {
            viewPlaylistsController.execute("Alice");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadPlaylists();

    }

    private void initializeUI(List<Song> songs) {
        setLayout(new BorderLayout());
        songList = new JList<>(new DefaultListModel<>());
        songs.forEach(((DefaultListModel<Song>) songList.getModel())::addElement);
        add(new JScrollPane(songList), BorderLayout.CENTER);

        addButton = new JButton("Add to Playlist");
        addButton.addActionListener(this::onAddButtonClicked);
        add(addButton, BorderLayout.SOUTH);
    }

    private void onAddButtonClicked(ActionEvent e) {
        Song selectedSong = songList.getSelectedValue();
        if (selectedSong != null && !playlists.isEmpty()) {
            String selectedPlaylist = (String) JOptionPane.showInputDialog(
                    this, "Select a Playlist:", "Add Song to Playlist",
                    JOptionPane.QUESTION_MESSAGE, null,
                    playlists.toArray(new String[0]), playlists.get(0));

            if (selectedPlaylist != null && !selectedPlaylist.isEmpty()) {
                addSongController.execute(selectedPlaylist, selectedSong);
                displayAddSongResult();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a song first", "No Song Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void displayAddSongResult() {
        // Implement the logic to display the result message
    }

    private void loadPlaylists() {
        playlists = viewPlaylistsViewModel.getState().getPlaylists();

        if (playlists == null || playlists.isEmpty()) {
            playlists = new ArrayList<>();
            JOptionPane.showMessageDialog(this, "No playlists available.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            playlists = viewPlaylistsViewModel.getState().getPlaylists();
            if (playlists == null || playlists.isEmpty()) {
                playlists = new ArrayList<>();
                JOptionPane.showMessageDialog(this, "No playlists available.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
