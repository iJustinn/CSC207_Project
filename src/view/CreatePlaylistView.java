package view;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreateViewModel;

public class CreatePlaylistView extends JPanel implements PropertyChangeListener {
    private JTextField playlistNameField;
    private JButton createButton;
    private CreateViewModel viewModel; // Assuming this is your ViewModel
    private CreatePlaylistController controller; // Assuming this is your Controller
    public final String viewName = "CreatePlaylist";

    public CreatePlaylistView(CreateViewModel viewModel, CreatePlaylistController controller) {
        this.viewModel = viewModel;
        this.controller = controller;
        viewModel.addPropertyChangeListener(this);

        initComponents();
        layoutComponents();
        attachListeners();
    }

    private void initComponents() {
        playlistNameField = new JTextField(20);
        createButton = new JButton("Create");
    }

    private void layoutComponents() {
        // Layout your components here
        // For example:
        add(playlistNameField);
        add(createButton);
    }

    private void attachListeners() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triggerPlaylistCreation();
            }
        });

        playlistNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    triggerPlaylistCreation();
                }
            }
        });
    }

    private void triggerPlaylistCreation() {
        String playlistName = playlistNameField.getText();
        if (!playlistName.trim().isEmpty()) {
            controller.execute(playlistName);
        } else {
            JOptionPane.showMessageDialog(this, "Playlist name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("creationStatusChanged".equals(evt.getPropertyName()) || "creationMessageChanged".equals(evt.getPropertyName())) {
            displayCreationStatus();
        }
    }

    private void displayCreationStatus() {
        if (viewModel.isCreationSuccessful()) {
            JOptionPane.showMessageDialog(this,
                    "Playlist created successfully: " + viewModel.getCreationMessage(),
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to create playlist: " + viewModel.getCreationMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
