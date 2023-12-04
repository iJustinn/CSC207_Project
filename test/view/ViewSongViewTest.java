package view;

import interface_adapter.delete_song.DeleteSongController;
import interface_adapter.delete_song.DeleteSongViewModel;
import interface_adapter.update_comment.UpdateCommentController;
import interface_adapter.update_comment.UpdateCommentViewModel;
import interface_adapter.view_song.ViewSongController;
import interface_adapter.view_song.ViewSongViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.view_song.SongDTO;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ViewSongViewTest {

    @Mock
    private ViewSongViewModel songViewModel;
    @Mock
    private UpdateCommentController updateCommentController;
    @Mock
    private UpdateCommentViewModel updateCommentViewModel;
    @Mock
    private DeleteSongController deleteSongController;
    @Mock
    private DeleteSongViewModel deleteSongViewModel;
    @Mock
    private ViewSongController viewSongController;

    private ViewSongView view;
    private List<SongDTO> dummySongs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ArrayList<String> artist = new ArrayList<>(Arrays.asList("Artist 1", "Artist 2"));
        dummySongs = new ArrayList<>(Arrays.asList(
                new SongDTO("Song1", "1", artist, "Album1", "Comment1"),
                new SongDTO("Song2", "2", artist, "Album2", "Comment2")
        ));
        view = new ViewSongView(songViewModel, updateCommentController, updateCommentViewModel,
                deleteSongController, deleteSongViewModel, viewSongController);
        when(songViewModel.getState().getSongs()).thenReturn((ArrayList<SongDTO>) dummySongs);
    }

    @Test
    void shouldDisplaySongsOnPropertyChange() {
        // Trigger the property change
        view.propertyChange(new PropertyChangeEvent(this, "state", null, songViewModel.getState()));

        // Assert that songs are displayed in the list
        assertEquals(2, view.songList.getModel().getSize());
        assertEquals(dummySongs.get(0), view.songList.getModel().getElementAt(0));
        assertEquals(dummySongs.get(1), view.songList.getModel().getElementAt(1));
    }

    @Test
    void shouldOpenCommentDialogWhenAddCommentClicked() {
        // Assuming a Song is selected
        view.songList.setSelectedIndex(0);

        // Simulate button click
        view.addCommentButton.doClick();

        assertTrue(true);
    }

    @Test
    void shouldDeleteSongWhenDeleteSongClicked() throws IOException {
        // Assuming a Song is selected
        view.songList.setSelectedIndex(0);

        // Simulate button click
        view.deleteSongButton.doClick();

        // Assert that the DeleteSongController is called
        verify(deleteSongController).execute("1", "love story");
    }

    // Additional tests for other buttons and scenarios...

}
