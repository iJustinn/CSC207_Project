package view;

import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentState;
import interface_adapter.update_comment.UpdateCommentViewModel;
import use_case.view_song.SongDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UpdateCommentView extends JPanel implements PropertyChangeListener, ActionListener {
    private JTextArea commentTextArea;
    private JButton updateButton;
    private JButton cancelButton;
    private UpdateCommentViewModel viewModel;
    private UpdateCommentController controller;
    private String songId;
    private String playlistId; // Added playlistId attribute

    public UpdateCommentView(UpdateCommentViewModel viewModel, UpdateCommentController controller) {
        this.viewModel = viewModel;
        this.controller = controller;
        viewModel.addPropertyChangeListener(this);
        initComponents();
        layoutComponents();
        attachListeners();
    }

    private void initComponents() {
        commentTextArea = new JTextArea(5, 20);
        updateButton = new JButton("Update");
        cancelButton = new JButton("Cancel");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(new JScrollPane(commentTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void prepareView(SongDTO song, String playlistId) {
        this.songId = song.getId();
        this.playlistId = playlistId; // Set the playlistId when preparing the view
        commentTextArea.setText(song.getComment());
    }

    private void attachListeners() {
        updateButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    private void triggerCommentUpdate() {
        String comment = commentTextArea.getText();
        if (!comment.trim().isEmpty()) {
            try {
                controller.updateComment(songId, comment, "love story");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error updating comment.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Comment cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof UpdateCommentState) {
            displayUpdateStatus((UpdateCommentState) evt.getNewValue());
        }
    }

    private void displayUpdateStatus(UpdateCommentState state) {
        if (state.isCommentUpdated()) {
            JOptionPane.showMessageDialog(this, "Comment updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Assuming the 'cardLayout' and 'cardPanel' are accessible here, or through a callback
            // cardLayout.show(cardPanel, "SongView");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update comment", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            triggerCommentUpdate();
        } else if (e.getSource() == cancelButton) {
            // Assuming the 'cardLayout' and 'cardPanel' are accessible here, or through a callback
            // cardLayout.show(cardPanel, "SongView");
        }
    }
}
