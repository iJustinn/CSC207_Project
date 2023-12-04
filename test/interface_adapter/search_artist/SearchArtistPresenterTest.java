package interface_adapter.search_artist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.search.search_artist.SearchArtistOutputData;
import entity.artist.ArtistFull;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchArtistPresenterTest {
    private SearchArtistViewModel viewModel;
    private SearchArtistPresenter presenter;

    @BeforeEach
    void setUp() {
        viewModel = new SearchArtistViewModel();
        presenter = new SearchArtistPresenter(viewModel);
    }

    @Test
    void prepareSuccessViewShouldUpdateViewModel() {
        // Mock artist data
        ArtistFull mockArtist = new ArtistFull("mockId", "Mock Artist", new String[]{"Pop", "Rock"}, 80);
        List<ArtistFull> mockArtistList = List.of(mockArtist);

        // Mock output data
        SearchArtistOutputData outputData = mock(SearchArtistOutputData.class);
        when(outputData.getArtists()).thenReturn(mockArtistList);

        presenter.prepareSuccessView(outputData);
        assertEquals(viewModel.getState().getArtists(), mockArtistList);
    }

    @Test
    void preparefail(){
        // Mock artist data
        ArtistFull mockArtist = new ArtistFull("mockId", "Mock Artist", new String[]{"Pop", "Rock"}, 80);
        List<ArtistFull> mockArtistList = List.of(mockArtist);

        // Mock output data
        SearchArtistOutputData outputData = mock(SearchArtistOutputData.class);
        when(outputData.getArtists()).thenReturn(mockArtistList);

        presenter.prepareFailView("sss");
        assertEquals(viewModel.getState().getSearchInput(),"sss");
    }
}
