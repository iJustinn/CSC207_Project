package view;

import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistState;
import interface_adapter.create_playlist.CreateViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreatePlaylistView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "CreatePlaylist";
    private final CreateViewModel createViewModel;
    private final CreatePlaylistController createPlaylistController;

    private final JButton createButton;
    private final JTextField playlistNameField;

    public CreatePlaylistView(CreateViewModel createViewModel, CreatePlaylistController createPlaylistController) {
        this.createViewModel = createViewModel;
        this.createPlaylistController = createPlaylistController;

        // Initialize components
        playlistNameField = new JTextField(20);
        createButton = new JButton("Create Playlist");

        // Add components to the panel
        add(playlistNameField);
        add(createButton);

        // Add action listener to the button
        createButton.addActionListener(this);

        // Register as a listener to the ViewModel
        createViewModel.addPropertyChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String playlistName = playlistNameField.getText();
            if (!playlistName.trim().isEmpty()) {
                createPlaylistController.createPlaylist(playlistName);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a playlist name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("playlistCreationStatus".equals(evt.getPropertyName())) {
            boolean creationSuccess = createViewModel.isCreationSuccessful();
            String message = createViewModel.getCreationMessage();
            if (creationSuccess) {
                JOptionPane.showMessageDialog(this, "Playlist created successfully: " + message, "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to create playlist: " + message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
