package view;

import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_song.ViewSongController;
import app.GUI_View_Playlists;

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
    private final JList<String> playlistsList;
    private final JButton refreshButton;

    public ViewPlaylistsView(ViewPlaylistsViewModel viewModel,
                             ViewPlaylistsController playlistsController,
                             ViewSongController viewSongController) {
        this.viewModel = viewModel;
        this.playlistsController = playlistsController;
        this.viewSongController = viewSongController;
        this.playlistsList = new JList<>();
        this.refreshButton = new JButton("Refresh Playlists");
        viewModel.addPropertyChangeListener(this);
        initUI();
    }

    private void initUI() {
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(playlistsList), BorderLayout.CENTER);

        refreshButton.addActionListener(this);
        this.add(refreshButton, BorderLayout.SOUTH);

        setupMouseListener();
    }

    private void setupMouseListener() {
        playlistsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = playlistsList.locationToIndex(evt.getPoint());
                if (index >= 0) {
                    String selectedPlaylist = playlistsList.getModel().getElementAt(index);
                    try {
                        viewSongController.execute("Alice", selectedPlaylist); // Replace "Alice" with the actual username
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    GUI_View_Playlists.switchToSongView();
                }
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updatePlaylistsList(viewModel.getState().getPlaylists());
        }
    }

    private void updatePlaylistsList(java.util.List<String> playlists) {
        playlistsList.setListData(new Vector<>(playlists));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refreshButton) {
            try {
                playlistsController.execute("Alice");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
