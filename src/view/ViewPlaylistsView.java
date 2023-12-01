package view;

import app.Main;
import app.GUI_View_Playlists;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistState;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_song.ViewSongController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Vector;

public class ViewPlaylistsView extends JPanel implements PropertyChangeListener, ActionListener {
    private final ViewPlaylistsViewModel viewModel;
    private final ViewPlaylistsController playlistsController;
    private final ViewSongController viewSongController;
    private final DeletePlaylistController deletePlaylistController;

    private final DeletePlaylistViewModel deletePlaylistViewModel;

    private final JList<String> playlistsList;
    // private final JButton refreshButton;
    private final JButton createPlaylistButton;
    private final JButton deletePlaylistButton;

    public ViewPlaylistsView(ViewPlaylistsViewModel viewModel,
                             ViewPlaylistsController playlistsController,
                             ViewSongController viewSongController,
                             DeletePlaylistController deletePlaylistController, DeletePlaylistViewModel deletePlaylistViewModel) {
        this.viewModel = viewModel;
        this.playlistsController = playlistsController;
        this.viewSongController = viewSongController;
        this.deletePlaylistController = deletePlaylistController;
        this.deletePlaylistViewModel = deletePlaylistViewModel;

        this.playlistsList = new JList<>();
        // this.refreshButton = new JButton("Refresh Playlists");
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
            Main.switchToCreateView();
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
