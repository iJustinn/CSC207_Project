package view;

import entity.song.Song;
import interface_adapter.add_song.AddSongController;
import interface_adapter.add_song.AddSongState;
import interface_adapter.add_song.AddSongViewModel;
import interface_adapter.view_playlists.ViewPlaylistsController;
import interface_adapter.view_playlists.ViewPlaylistsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.SongListView;

import javax.swing.*;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class SongListViewTest {
    @Mock private AddSongController addSongController;
    @Mock private ViewPlaylistsController viewPlaylistsController;
    @Mock private ViewPlaylistsViewModel viewPlaylistsViewModel;
    @Mock private AddSongViewModel addSongViewModel;

    private SongListView songListView;
    private JList<Song> songsList;
    private DefaultListModel<Song> listModel;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        ArrayList<String> artistsJustice = new ArrayList<>(Arrays.asList("Artist Name for Justice"));
        ArrayList<String> artistsPurpose = new ArrayList<>(Arrays.asList("Artist Name for Purpose"));

        Song songJustice = new Song("Justice", artistsJustice, "Justice", "1");
        Song songPurpose = new Song("Purpose", artistsPurpose, "Purpose", "2");

        // Create a DefaultListModel and add the songs to it
        listModel = new DefaultListModel<>();
        songsList = new JList<>(listModel);
        listModel.addElement(songJustice);
        listModel.addElement(songPurpose);

        // Create a JList with the model
        songsList = new JList<>(listModel);

        // Initialize SongListView with the mock objects and the songs list
        songListView = new SongListView(songsList, addSongController, viewPlaylistsController, viewPlaylistsViewModel, addSongViewModel);
    }

    @Test
    void testConstructor() {
        assertNotNull(songListView); // if all components are initialized correctly
    }

    @Test
    void testSongDisplay() {
        // Create new songs and update the song list view
        ArrayList<String> artistsJustice = new ArrayList<>(Arrays.asList("Artist Name for Justice"));
        ArrayList<String> artistsPurpose = new ArrayList<>(Arrays.asList("Artist Name for Purpose"));
        Song songJustice = new Song("Justice", artistsJustice, "Justice Album", "1");
        Song songPurpose = new Song("Purpose", artistsPurpose, "Purpose Album", "2");
        List<Song> newSongs = Arrays.asList(songJustice, songPurpose);

        songListView.updateSongs(newSongs); // Update songs in the SongListView

        // Check if the model of the song list is updated
        assertEquals(2, listModel.getSize()); // Check if the list model has 2 songs
        assertEquals(songJustice, listModel.getElementAt(0)); // Check the first song
        assertEquals(songPurpose, listModel.getElementAt(1)); // Check the second song
    }

    @Test
    void testPropertyChangeReaction() {
        // Mock state change in addSongViewModel
        AddSongState mockAddSongState = mock(AddSongState.class);
        when(mockAddSongState.getMessage()).thenReturn("The song was successfully added.");
        PropertyChangeEvent addSongEvt = new PropertyChangeEvent(addSongViewModel, "state", null, mockAddSongState);
        songListView.propertyChange(addSongEvt);

        // Verify if a success message is shown
        verify(addSongViewModel).getState();
    }
}
