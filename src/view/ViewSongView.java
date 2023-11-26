package view;

import interface_adapter.view_song.ViewSongViewModel;
import use_case.view_song.SongDTO;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

public class ViewSongView extends JPanel implements PropertyChangeListener {
    private final ViewSongViewModel viewModel;
    private final JList<String> songList;

    public ViewSongView(ViewSongViewModel viewModel) {
        this.viewModel = viewModel;
        this.songList = new JList<>();
        viewModel.addPropertyChangeListener(this);
        initUI();
    }

    private void initUI() {
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(songList), BorderLayout.CENTER);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateSongList(viewModel.getState().getSongs());
        }
    }

    private void updateSongList(java.util.List<SongDTO> songs) {
        Vector<String> songDetails = new Vector<>();
        for (SongDTO song : songs) {
            songDetails.add(song.getTitle() + " - " + String.join(", ", song.getArtist()) +
                    " | Album: " + song.getAlbum() + " | Comment: " + song.getComment());
        }
        songList.setListData(songDetails);
    }
}
