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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class ViewSongViewTest {

    @Mock
    private ViewSongViewModel viewModel;
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

    private ViewSongView viewSongView;
    private ArrayList<SongDTO> songs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewSongView = new ViewSongView(viewModel, updateCommentController, updateCommentViewModel,
                deleteSongController, deleteSongViewModel, viewSongController);
        songs = new ArrayList<>(Arrays.asList(
                new SongDTO("Song1", "1", new ArrayList<>(Arrays.asList("Artist1")), "Album1", "Comment1"),
                new SongDTO("Song2", "2", new ArrayList<>(Arrays.asList("Artist2")), "Album2", "Comment2")
        ));
        when(viewModel.getState().getSongs()).thenReturn(songs);
    }

    @Test
    void testOpenUpdateCommentViewWithSelectedSong() {
        // Simulate selecting a song
        viewSongView.songList.setSelectedIndex(0);

        // Simulate clicking the add comment button
        viewSongView.addCommentButton.doClick();

    }

    @Test
    void testDeleteSelectedSong() throws IOException {
        // Simulate selecting a song
        viewSongView.songList.setSelectedIndex(0);

        // Simulate clicking the delete song button
        viewSongView.deleteSongButton.doClick();

        // Verify that the delete song controller is executed
        verify(deleteSongController).execute(eq("1"), eq("love story"));
        verify(viewSongController).execute(eq("Alice"), eq("love story"));
    }

    @Test
    void testSelection() throws IOException {

    }
}
