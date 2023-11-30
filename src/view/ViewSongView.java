package view;

import interface_adapter.view_song.ViewSongViewModel;
import use_case.view_song.SongDTO;
import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class ViewSongView extends JPanel {
    private final ViewSongViewModel viewModel;
    private final JList<SongDTO> songList; // Changed to JList<SongDTO>
    private final JButton addCommentButton;
    private final UpdateCommentController updateCommentController;
    private final UpdateCommentViewModel updateCommentViewModel;
    private UpdateCommentView updateCommentView;

    public ViewSongView(ViewSongViewModel viewModel,
                        UpdateCommentController updateCommentController,
                        UpdateCommentViewModel updateCommentViewModel) {
        this.viewModel = viewModel;
        this.updateCommentController = updateCommentController;
        this.updateCommentViewModel = updateCommentViewModel;
        this.songList = new JList<>();
        this.addCommentButton = new JButton("Add Comment");

        viewModel.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                updateSongList(viewModel.getState().getSongs());
            }
        });

        initUI();
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
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addCommentButton);
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

    private void updateSongList(java.util.List<SongDTO> songs) {
        // Convert the ArrayList to an array and set it as the list data
        SongDTO[] songArray = new SongDTO[songs.size()];
        songs.toArray(songArray);
        songList.setListData(songArray);
    }
}
