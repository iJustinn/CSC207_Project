package view;

import entity.song.Song;
import interface_adapter.get_album_songs.GetSongsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlbumViewTest {

    @Mock
    private GetSongsViewModel viewModel;

    private AlbumView albumView;
    private CustomListModel<Song> listModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create mock songs for initial state
        List<Song> initialSongs = Arrays.asList(new Song("Song 1", null, "Album X", "1"));
        when(viewModel.getState().getSongs()).thenReturn(initialSongs);

        albumView = new AlbumView(viewModel);
        listModel = (CustomListModel<Song>) ((JList<Song>) albumView.getComponent(0)).getModel();
    }

    @Test
    void testInitialization() {
        // Verify that the list model is initialized with songs from viewModel
        assertNotNull(listModel);
        assertEquals(1, listModel.getSize());
        assertEquals("Song 1", listModel.getElementAt(0).getTitle());
    }

    @Test
    void testPropertyChangeHandling() {
        // Mock new songs list
        List<Song> newSongs = Arrays.asList(new Song("Song 2", null, "Album X", "2"));
        when(viewModel.getState().getSongs()).thenReturn(newSongs);

        // Simulate property change
        albumView.propertyChange(new PropertyChangeEvent(this, "state", null, null));

        // Verify that the list model is updated
        assertEquals(1, listModel.getSize());
        assertEquals("Song 2", listModel.getElementAt(0).getTitle());
    }

    @Test
    void testWithNoSongs() {
        // Mock no songs in the viewModel
        when(viewModel.getState().getSongs()).thenReturn(new ArrayList<>());

        // Trigger the property change
        albumView.propertyChange(new PropertyChangeEvent(this, "state", null, null));

        // Verify the list model is empty
        assertEquals(0, listModel.getSize());
    }

    @Test
    void testExceptionHandling() {
        // Suppose propertyChange handles exceptions by showing a dialog
        doThrow(new RuntimeException("Test Exception")).when(viewModel).getState();

        // Trigger the property change
        albumView.propertyChange(new PropertyChangeEvent(this, "state", null, null));
    }
}
