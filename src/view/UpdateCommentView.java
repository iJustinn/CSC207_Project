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


    private void displayUpdateStatus(UpdateCommentState state) {
        // Check if the comment was updated successfully
        if (state.isCommentUpdated()) {
            // Display a success message
            JOptionPane.showMessageDialog(this, "Comment updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            // After displaying the message, you might want to close the dialog or reset the view
            resetView();
        } else {
            // Display an error message if the update was not successful
            JOptionPane.showMessageDialog(this, "Failed to update comment", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Resets the view to its default state
    private void resetView() {
        commentTextArea.setText("");
        // Assuming the 'cardLayout' and 'cardPanel' are accessible here, or through a callback
        // cardLayout.show(cardPanel, "SongView");
        // If you are using a JDialog to show the UpdateCommentView, you would hide it like this:
        // SwingUtilities.getWindowAncestor(this).setVisible(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("commentUpdate".equals(evt.getPropertyName())) {
            displayUpdateStatus((UpdateCommentState) evt.getNewValue());
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            triggerCommentUpdate();
        } else if (e.getSource() == cancelButton) {
            // Close the dialog or reset the view here as well
            resetView();
        }
    }

}
