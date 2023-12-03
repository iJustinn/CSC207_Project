package view;

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

import static org.mockito.Mockito.*;

public class ViewPlaylistsViewTest {

    @Mock
    private ViewPlaylistsViewModel mockViewModel;
    @Mock
    private ViewPlaylistsController mockPlaylistsController;
    @Mock
    private ViewSongController mockViewSongController;
    @Mock
    private DeletePlaylistController mockDeletePlaylistController;
    @Mock
    private DeletePlaylistViewModel mockDeletePlaylistViewModel;



    @Test
    void testPlaylistSelectionAndDelete() throws IOException {
        // Assume there is a playlist called "TestPlaylist"
        java.util.List<String> testPlaylists = new java.util.ArrayList<>();
        testPlaylists.add("TestPlaylist");

        // Simulate the view model updating the list of playlists

        // Simulate a property change event

        // Select a playlist in the view

        // Simulate delete button click

        // Verify that the delete playlist controller's method was called
        verify(mockDeletePlaylistController, times(1)).deletePlaylist("TestPlaylist");

        // You can also verify if the view updated correctly (e.g., showing a dialog)
    }

    // Utility method to access private fields for testing
    private Object getField(Object obj, String fieldName) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
