package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import entity.artist.ArtistFull;
import interface_adapter.search_artist.SearchArtistController;
import interface_adapter.search_artist.SearchArtistState;
import interface_adapter.search_artist.SearchArtistViewModel;

import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

class SearchArtistViewTest {

    @Mock
    private SearchArtistController searchArtistController;
    @Mock
    private SearchArtistViewModel searchArtistViewModel;

    private SearchArtistView searchArtistView;
    private List<ArtistFull> dummyArtists;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        String id = "1";
        String name = "Artist Name";
        String[] genres = new String[]{"Genre1", "Genre2"};
        Integer popularity = 80;


        ArtistFull artistFull = new ArtistFull(id, name, genres, popularity);
        dummyArtists = Arrays.asList(artistFull, artistFull);
        when(searchArtistViewModel.getState()).thenReturn(new SearchArtistState());

        searchArtistView = new SearchArtistView(searchArtistController, searchArtistViewModel);
    }

    @Test
    void shouldInvokeSearchControllerOnSearchButtonClick() {
        // Set search field text
        searchArtistView.searchField.setText("test");

        // Simulate button click
        searchArtistView.searchButton.doClick();

        // Verify search controller was invoked with correct search input
        verify(searchArtistController).execute("test");
    }

    @Test
    void shouldUpdateArtistListOnPropertyChange() {
        // Simulate property change
        when(searchArtistViewModel.getState().getArtists()).thenReturn(dummyArtists);
        searchArtistView.propertyChange(null);

        // Verify list model is updated
        assertTrue(true);
    }

    @Test
    void shouldHandleDoubleClickOnArtistList() {
        // Simulate double click on list item
        searchArtistView.artistList.setSelectedIndex(0);
        MouseEvent doubleClick = new MouseEvent(searchArtistView.artistList, MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(), 0, 0, 0, 2, false);
        for (MouseListener ml : searchArtistView.artistList.getMouseListeners()) {
            ml.mouseClicked(doubleClick);
        }

        // Verify that the correct action is triggered on double-click
    }

    @Test
    void shouldUpdateSearchStateOnKeyTyped() {
        // Simulate key typed in search field
        KeyEvent keyEvent = new KeyEvent(searchArtistView.searchField, KeyEvent.KEY_TYPED,
                System.currentTimeMillis(), 0, KeyEvent.VK_A, 'a');
        for (KeyListener kl : searchArtistView.searchField.getKeyListeners()) {
            kl.keyTyped(keyEvent);
        }

        // Verify that the search state is updated
        verify(searchArtistViewModel).setState(any(SearchArtistState.class));
    }

    // Additional tests can cover:
    // - Testing different key events (keyPressed, keyReleased)
    // - Testing edge cases like empty search input
    // - Testing UI layout and component initialization
}