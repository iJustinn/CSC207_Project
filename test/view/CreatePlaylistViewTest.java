package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreateViewModel;

import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;

class CreatePlaylistViewTest {

    @Mock
    private CreatePlaylistController controller;
    private CreateViewModel viewModel;
    private CreatePlaylistView view;

    @Captor
    private ArgumentCaptor<ActionEvent> actionEventCaptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new CreateViewModel();
        view = new CreatePlaylistView(viewModel, controller);
    }

    @Test
    void triggerPlaylistCreation() {
        // Simulate typing a playlist name and pressing the create button
        view.playlistNameField.setText("New Playlist");
        view.createButton.doClick();

        verify(controller, times(1)).execute("New Playlist");
    }

    // Additional tests to verify the reaction to property change events
}
