package spotify;

import org.junit.jupiter.api.Test;

public class ModelsTest {
    @Test
    public void testAlbumModel() {
        SpotifyEndpoint spotify = new SpotifyEndpoint();
        spotify.searchAlbum("q");
    }
}
