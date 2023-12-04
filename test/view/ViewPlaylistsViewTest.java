package view;

import interface_adapter.view_song.ViewSongController;
import interface_adapter.create_playlist.CreateViewModel;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.delete_playlist.DeletePlaylistViewModel;
import interface_adapter.delete_playlist.DeletePlaylistController;
import interface_adapter.create_playlist.CreatePlaylistController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

class ViewPlaylistsViewTest {

    @Mock
    private ViewPlaylistsViewModel viewPlaylistsViewModel;
    @Mock
    private ViewPlaylistsController viewPlaylistsController;
    @Mock
    private ViewSongController viewSongController;
    @Mock
    private DeletePlaylistViewModel deletePlaylistViewModel;
    @Mock
    private DeletePlaylistController deletePlaylistController;
    @Mock
    private CreateViewModel createViewModel;
    @Mock
    private CreatePlaylistController createPlaylistController;

    private ViewPlaylistsView viewPlaylistsView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewPlaylistsView = new ViewPlaylistsView(
                viewPlaylistsViewModel,
                viewPlaylistsController,
                viewSongController,
                deletePlaylistController,
                deletePlaylistViewModel,
                createViewModel,
                createPlaylistController
        );
    }

    @Test
    void shouldTriggerPlaylistCreation() throws IOException {
        viewPlaylistsView.playlistNameField.setText("New Playlist");
        viewPlaylistsView.createPlaylistButton.doClick();

        verify(createPlaylistController).execute("New Playlist");
        verify(viewPlaylistsController).execute("Alice");
    }

    @Test
    void shouldTriggerPlaylistDeletion() throws IOException {
        JList<String> playlistsList = viewPlaylistsView.playlistsList;
        playlistsList.setListData(new String[]{"Playlist 1"});
        playlistsList.setSelectedIndex(0);

        viewPlaylistsView.deletePlaylistButton.doClick();

        verify(deletePlaylistController).deletePlaylist("Playlist 1");
        verify(viewPlaylistsController).execute("Alice");
    }

    @Test
    void shouldUpdatePlaylistsList() {
        java.util.List<String> playlists = java.util.Arrays.asList("Playlist 1", "Playlist 2");
        when(viewPlaylistsViewModel.getState().getPlaylists()).thenReturn((ArrayList<String>) playlists);

        viewPlaylistsView.propertyChange(new PropertyChangeEvent(this, "state", null, viewPlaylistsViewModel.getState()));

    }

    @Test
    void shouldHandlePlaylistSelection() throws IOException {
        JList<String> playlistsList = viewPlaylistsView.playlistsList;
        playlistsList.setListData(new String[]{"love story"});
        playlistsList.setSelectedIndex(0);

        viewPlaylistsView.playlistsList.getMouseListeners()[1].mouseClicked(null);

        verify(viewSongController).execute("Alice", "love story");
    }

    @Test
    void shouldDisplaySuccessMessageOnPlaylistCreation() {
        when(createViewModel.isCreationSuccessful()).thenReturn(true);
        when(createViewModel.getCreationMessage()).thenReturn("Playlist created successfully");

        viewPlaylistsView.propertyChange(new PropertyChangeEvent(this, "state", null, createViewModel.getState()));

        // Verify if a success message dialog was displayed
    }

    @Test
    void shouldDisplayErrorMessageOnFailedPlaylistCreation() {
        when(createViewModel.isCreationSuccessful()).thenReturn(false);
        when(createViewModel.getCreationMessage()).thenReturn("Failed to create playlist");

        viewPlaylistsView.propertyChange(new PropertyChangeEvent(this, "state", null, createViewModel.getState()));

        // Verify if an error message dialog was displayed
    }

    @Test
    void shouldNotCreatePlaylistWithEmptyName() throws IOException {
        viewPlaylistsView.playlistNameField.setText("");
        viewPlaylistsView.createPlaylistButton.doClick();

        verifyNoInteractions(createPlaylistController);
    }

    @Test
    void shouldDisplayDeletionSuccessMessage() {
        when(deletePlaylistViewModel.getState().isDeletionSuccessful()).thenReturn(true);
        viewPlaylistsView.propertyChange(new PropertyChangeEvent(this, "state", null, deletePlaylistViewModel.getState()));

        // Verify if a success message dialog was displayed
    }

    @Test
    void shouldDisplayDeletionErrorMessage() {
        when(deletePlaylistViewModel.getState().isDeletionSuccessful()).thenReturn(false);
        viewPlaylistsView.propertyChange(new PropertyChangeEvent(this, "state", null, deletePlaylistViewModel.getState()));
    }
    @Test
    void mouseClickedShouldTriggerViewSongController() throws IOException {
        // Simulate a mouse click on the first item in the playlists list
        int indexToClick = 0;
        MouseEvent mockEvent = mock(MouseEvent.class);
        when(mockEvent.getPoint()).thenReturn(new java.awt.Point(0, viewPlaylistsView.playlistsList.indexToLocation(indexToClick).y));
        viewPlaylistsView.playlistsList.getMouseListeners()[1].mouseClicked(mockEvent);

        // Verify that the viewSongController is called with the correct playlist
        verify(viewSongController).execute("Alice", "Playlist 1");
    }
}
