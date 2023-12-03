package view;

import interface_adapter.create_playlist.CreatePlaylistController;
import interface_adapter.create_playlist.CreateViewModel;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import interface_adapter.view_song.ViewSongController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class ViewPlaylistsViewTest {

    @Mock
    private ViewPlaylistsViewModel viewModel;
    @Mock
    private ViewPlaylistsController playlistsController;
    @Mock
    private ViewSongController viewSongController;
    @Mock
    private DeletePlaylistController deletePlaylistController;
    @Mock
    private DeletePlaylistViewModel deletePlaylistViewModel;
    @Mock
    private CreateViewModel createViewModel;
    @Mock
    private CreatePlaylistController createPlaylistController;

    private ViewPlaylistsView view;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        view = new ViewPlaylistsView(viewModel, playlistsController, viewSongController, deletePlaylistController, deletePlaylistViewModel, createViewModel, createPlaylistController);
    }

    @Test
    void shouldDisplayPlaylistsOnPropertyChange() {
        // Given
        var playlists = java.util.List.of("Playlist 1", "Playlist 2");
        when(viewModel.getState().getPlaylists());

        // When
        viewModel.firePropertyChanged(); // Simulate property change

        // Then
        var listModel = (DefaultListModel<String>) view.playlistsList.getModel();
        assertEquals(playlists.size(), listModel.getSize());
        for (int i = 0; i < playlists.size(); i++) {
            assertEquals(playlists.get(i), listModel.getElementAt(i));
        }
    }

    @Test
    void shouldInvokeDeletePlaylistWhenDeleteButtonPressed() throws IOException {
        // Given
        String selectedPlaylist = "Playlist 1";
        view.playlistsList.setSelectedValue(selectedPlaylist, true);

        // When
        view.deletePlaylistButton.doClick();

        // Then
        verify(deletePlaylistController).deletePlaylist(selectedPlaylist);
    }

    @Test
    void shouldShowErrorMessageWhenDeletePlaylistFails() throws IOException {
        // Given
        String selectedPlaylist = "Playlist 1";
        view.playlistsList.setSelectedValue(selectedPlaylist, true);
        doThrow(new IOException()).when(deletePlaylistController).deletePlaylist(anyString());

        // When
        view.deletePlaylistButton.doClick();

        // Then
        // You can check if an error dialog was displayed, but this requires additional setup with JOptionPane mocking.
    }

    // Additional tests for createPlaylistButton and refreshButton can be created in a similar manner.
}
