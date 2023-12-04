package interface_adapter.search_album;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import entity.album.AlbumSimple;
import use_case.search.search_album.SearchAlbumOutputData;
import java.util.ArrayList;
import java.util.List;

class SearchAlbumPresenterTest {
    private SearchAlbumViewModel viewModel;
    private SearchAlbumPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new SearchAlbumViewModel();
        presenter = new SearchAlbumPresenter(viewModel);
    }

    @Test
    void prepareSuccessView() {
        List<AlbumSimple> albums = new ArrayList<>();
        albums.add(new AlbumSimple("Album 1", "Artist 1"));
        SearchAlbumOutputData outputData = new SearchAlbumOutputData(albums);

        presenter.prepareSuccessView(outputData);

        assertEquals(albums, viewModel.getState().getAlbums());
    }

    @Test
    void prepareFailView() {
        // Assuming that prepareFailView will modify the state in a specific way
        presenter.prepareFailView("Error occurred");
        // Assertions based on how the state should change after prepareFailView is called
    }
}
