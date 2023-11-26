package view;

import interface_adapter.view_playlists.ViewPlaylistsState;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewPlaylistsView extends JPanel implements PropertyChangeListener {
    private final ViewPlaylistsViewModel viewModel;
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> playlistList = new JList<>(listModel);

    public ViewPlaylistsView(ViewPlaylistsViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        add(new JScrollPane(playlistList), BorderLayout.CENTER);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewPlaylistsState state = (ViewPlaylistsState) evt.getNewValue();
        updatePlaylists(state.getPlaylists());
    }

    private void updatePlaylists(java.util.List<String> playlists) {
        listModel.clear();
        for (String playlist : playlists) {
            listModel.addElement(playlist);
        }
    }
}