package interface_adapter.get_album_songs;

import org.junit.Before;
import org.junit.Test;
import use_case.get_album_songs.GetAlbumSongsInputBoundary;
import use_case.get_album_songs.GetAlbumSongsInputData;

import static org.mockito.Mockito.*;

public class GetSongsControllerTest {
    private GetAlbumSongsInputBoundary interactor;
    private GetSongsController controller;

    @Before
    public void setUp() {
        interactor = mock(GetAlbumSongsInputBoundary.class);
        controller = new GetSongsController(interactor);
    }

    @Test
    public void testExecute() {
        String testId = "testId";
        controller.execute(testId);
        verify(interactor).execute(any(GetAlbumSongsInputData.class));
    }
}
