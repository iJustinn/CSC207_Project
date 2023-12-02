package view;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistState;
import interface_adapter.create_playlist.CreateViewModel;

public class CreatePlaylistView extends JPanel implements PropertyChangeListener {
    JTextField playlistNameField;
    JButton createButton;
    private CreateViewModel viewModel;
    private final CreatePlaylistController controller;
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
        if (evt.getNewValue() instanceof CreatePlaylistState) {
            displayCreationStatus();
        }
    }

    private void displayCreationStatus() {
        if (viewModel.isCreationSuccessful()) {
            JOptionPane.showMessageDialog(this,
                    viewModel.getState().getMessage(),
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    viewModel.getState().getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
