package view;

import app.Main;
import interface_adapter.view_song.ViewSongController;
import interface_adapter.create_playlist.CreateViewModel;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistController;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewPlaylistsView extends JPanel implements PropertyChangeListener, ActionListener {
    private final ViewPlaylistsViewModel viewModel;
    private final ViewPlaylistsController playlistsController;
    private final ViewSongController viewSongController;
    private final DeletePlaylistController deletePlaylistController;
    private final DeletePlaylistViewModel deletePlaylistViewModel;
    private final CreateViewModel createViewModel;
    private final CreatePlaylistController createPlaylistController;

    final JList<String> playlistsList;
    // private final JButton refreshButton;
    public JTextField playlistNameField;
    public final JButton createPlaylistButton;
    final JButton deletePlaylistButton;

    public ViewPlaylistsView(ViewPlaylistsViewModel viewModel,
                                  ViewPlaylistsController playlistsController,
                                  ViewSongController viewSongController,
                                  DeletePlaylistController deletePlaylistController, DeletePlaylistViewModel deletePlaylistViewModel, CreateViewModel createViewModel, CreatePlaylistController createPlaylistController) {
        this.viewModel = viewModel;
        this.playlistsController = playlistsController;
        this.viewSongController = viewSongController;
        this.deletePlaylistController = deletePlaylistController;
        this.deletePlaylistViewModel = deletePlaylistViewModel;
        this.createViewModel = createViewModel;
        this.createPlaylistController = createPlaylistController;

        this.playlistsList = new JList<>();
        // this.refreshButton = new JButton("Refresh Playlists");
        this.playlistNameField = new JTextField(20);

        this.createPlaylistButton = new JButton("Create Playlist");
        this.deletePlaylistButton = new JButton("Delete Playlist");

        viewModel.addPropertyChangeListener(this);
        deletePlaylistViewModel.addPropertyChangeListener(this);
        initUI();
        try {
            playlistsController.execute("Alice");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initUI() {
        setLayout(new BorderLayout());
        add(new JScrollPane(playlistsList), BorderLayout.CENTER);

        JPanel createPanel = new JPanel();
        createPanel.add(playlistNameField);
        createPanel.add(createPlaylistButton);
        add(createPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createPlaylistButton);
        buttonPanel.add(deletePlaylistButton);
        // buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);

        createPlaylistButton.addActionListener(this);
        deletePlaylistButton.addActionListener(this);
        // refreshButton.addActionListener(this);
        setupMouseListener();
    }

    private void setupMouseListener() {
        playlistsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = playlistsList.locationToIndex(evt.getPoint());
                if (index >= 0) {
                    String selectedPlaylist = playlistsList.getModel().getElementAt(index);
                    try {
                        viewSongController.execute("Alice", selectedPlaylist);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Main.switchToSongView();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createPlaylistButton) {
            triggerPlaylistCreation();
            try {
                playlistsController.execute("Alice");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == deletePlaylistButton) {
            String selectedPlaylist = playlistsList.getSelectedValue();
            if (selectedPlaylist != null && !selectedPlaylist.isEmpty()) {
                try {
                    deletePlaylistController.deletePlaylist(selectedPlaylist);
                    // Refresh the playlists after deletion
                    playlistsController.execute("Alice");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a playlist to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void triggerPlaylistCreation() {
        String playlistName = playlistNameField.getText();
        if (!playlistName.trim().isEmpty()) {
            createPlaylistController.execute(playlistName); // Create playlist
            try {
                playlistsController.execute("Alice"); // Refresh playlists
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Playlist name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updatePlaylistsList(viewModel.getState().getPlaylists());
        }
        if (evt.getSource() == deletePlaylistViewModel) {
            if (deletePlaylistViewModel.getState().isDeletionSuccessful()) {
                JOptionPane.showMessageDialog(this,
                        "Playlist deleted successfully",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to delete playlist",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updatePlaylistsList(java.util.List<String> playlists) {
        playlistsList.setListData(new Vector<>(playlists));
    }
}
