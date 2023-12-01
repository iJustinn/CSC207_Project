package view;

import entity.song.Song;
import interface_adapter.get_album_songs.GetSongsViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class AlbumView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get songs";

    private JList<Song> songs;
    private CustomListModel<Song> listModel;

    private final GetSongsViewModel viewModel;

    public AlbumView(GetSongsViewModel viewModel) {
        JLabel title = new JLabel("Album X");
        viewModel.addPropertyChangeListener(this);

        this.viewModel = viewModel;

        listModel = new CustomListModel<>(viewModel.getState().getSongs());
        songs = new JList<>(listModel);

        this.add(songs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        List<Song> newSongs = viewModel.getState().getSongs();
        listModel.setList(newSongs);
        listModel.fireDataChanged();
    }
}
