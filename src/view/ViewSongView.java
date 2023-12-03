package view;

import interface_adapter.delete_song.DeleteSongState;
import interface_adapter.delete_song.DeleteSongViewModel;
import interface_adapter.view_song.ViewSongController;
import interface_adapter.view_song.ViewSongViewModel;
import use_case.view_song.SongDTO;
import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentViewModel;
import interface_adapter.delete_song.DeleteSongController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class ViewSongView extends JPanel implements PropertyChangeListener {
    private final ViewSongViewModel viewModel;
    public final JList<SongDTO> songList;
    public final JButton addCommentButton;
    public final JButton deleteSongButton;
    private final UpdateCommentController updateCommentController;
    private final UpdateCommentViewModel updateCommentViewModel;
    private final DeleteSongViewModel deleteSongViewModel;
    private UpdateCommentView updateCommentView;
    private final DeleteSongController deleteSongController;
    private final ViewSongController viewSongController;
    private String playlistName = "love story"; // Name of the playlist being viewed

    public ViewSongView(ViewSongViewModel viewModel,
                        UpdateCommentController updateCommentController,
                        UpdateCommentViewModel updateCommentViewModel,
                        DeleteSongController deleteSongController, DeleteSongViewModel deleteSongViewModel, ViewSongController viewSongController) {
        this.viewModel = viewModel;
        this.updateCommentController = updateCommentController;
        this.updateCommentViewModel = updateCommentViewModel;
        this.deleteSongViewModel = deleteSongViewModel;
        this.deleteSongController = deleteSongController;
        this.viewSongController = viewSongController;
        this.songList = new JList<>();
        this.addCommentButton = new JButton("Add Comment");
        this.deleteSongButton = new JButton("Delete Song");
        deleteSongViewModel.addPropertyChangeListener(this);

        viewModel.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                updateSongList(viewModel.getState().getSongs());
            }
        });

        initUI();
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    private void initUI() {
        setLayout(new BorderLayout());
        songList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof SongDTO) {
                    SongDTO song = (SongDTO) value;
                    setText(song.getTitle() + " - " + String.join(", ", song.getArtist()) +
                            " | Album: " + song.getAlbum() + " | Comment: " + song.getComment());
                }
                return renderer;
            }
        });
        add(new JScrollPane(songList), BorderLayout.CENTER);

        updateCommentView = new UpdateCommentView(updateCommentViewModel, updateCommentController);

        addCommentButton.addActionListener(this::openUpdateCommentView);
        deleteSongButton.addActionListener(e -> {
            try {
                deleteSelectedSong(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addCommentButton);
        buttonPanel.add(deleteSongButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openUpdateCommentView(ActionEvent e) {
        SongDTO selectedSong = songList.getSelectedValue();
        if (selectedSong != null) {
            updateCommentView.prepareView(selectedSong, selectedSong.getId());
            JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(this), "Add Comment", Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setContentPane(updateCommentView);
            dialog.pack();
            dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a song to comment on.", "No Song Selected", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void deleteSelectedSong(ActionEvent e) throws IOException {
        SongDTO selectedSong = songList.getSelectedValue();
        if (selectedSong != null) {
            deleteSongController.execute(selectedSong.getId(), playlistName);
            viewSongController.execute("Alice", "love story");// Delete the selected song
        } else {
            JOptionPane.showMessageDialog(this, "Please select a song to delete.", "No Song Selected", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateSongList(java.util.List<SongDTO> songs) {
        // Convert the ArrayList to an array and set it as the list data
        SongDTO[] songArray = new SongDTO[songs.size()];
        songs.toArray(songArray);
        songList.setListData(songArray);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            if (evt.getNewValue() instanceof DeleteSongState) {
                if (deleteSongViewModel.isDeletionSuccessful()) {
                    JOptionPane.showMessageDialog(this,
                            "Song deleted successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Failed to delete song",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }
}
