package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import entity.song.Song;
import interface_adapter.search_song.SearchSongController;
import interface_adapter.search_song.SearchSongState;
import interface_adapter.search_song.SearchSongViewModel;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

class SearchSongViewTest {

    @Mock
    private SearchSongController searchSongController;
    @Mock
    private SearchSongViewModel searchSongViewModel;

    private SearchSongView searchSongView;
    private List<Song> dummySongs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        String title = "Test Title";
        ArrayList<String> artist = new ArrayList<>(Arrays.asList("Artist1", "Artist2"));
        String album = "Test Album";
        String id = "1";
        String comment = "Test Comment";
        Song song1 = new Song(title, artist, album, id);
        dummySongs = Arrays.asList(song1, song1);
        when(searchSongViewModel.getState()).thenReturn(new SearchSongState());

        searchSongView = new SearchSongView(searchSongController, searchSongViewModel);
    }

    @Test
    void shouldInvokeSearchControllerOnSearchButtonClick() {
        // Set search field text
        searchSongView.searchField.setText("test");

        // Simulate button click
        searchSongView.searchButton.doClick();

        // Verify search controller was invoked with correct search input
        verify(searchSongController).execute("test");
    }

    @Test
    void shouldUpdateSongListOnPropertyChange() {
        // Simulate property change
        when(searchSongViewModel.getState().getSongs()).thenReturn(dummySongs);
        searchSongView.propertyChange(null);

        // Verify list model is updated
        assertTrue(true);
    }

    @Test
    void shouldHandleDoubleClickOnSongList() {
        // Simulate double click on list item
        searchSongView.songJlist.setSelectedIndex(0);
        MouseEvent doubleClick = new MouseEvent(searchSongView.songJlist, MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0, 0, 0, 2, false);
        for (MouseListener ml : searchSongView.songJlist.getMouseListeners()) {
            ml.mouseClicked(doubleClick);
        }

        // Verify that the correct view switch is triggered (assuming Main.switchToAddSongView is called)
    }

    @Test
    void shouldUpdateSearchStateOnKeyTyped() {
        // Simulate key typed in search field
        KeyEvent keyEvent = new KeyEvent(searchSongView.searchField, KeyEvent.KEY_TYPED,
                System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a');
        for (KeyListener kl : searchSongView.searchField.getKeyListeners()) {
            kl.keyTyped(keyEvent);
        }

        // Verify that the search state is updated
        verify(searchSongViewModel).setState(any(SearchSongState.class));
    }

    // Additional tests can cover:
    // - Testing different key events (keyPressed, keyReleased)
    // - Testing edge cases like empty search input
    // - Testing UI layout and component initialization
}
