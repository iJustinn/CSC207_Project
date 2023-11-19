package spotify.services;

import org.junit.jupiter.api.Test;
import spotify.models.AlbumSimpleModel;

import static org.junit.jupiter.api.Assertions.*;

class SearchAlbumServiceTest {
    @Test
    void requestSearchAlbum() {
        SearchAlbumService searchAlbumService = new SearchAlbumService();
        AlbumSimpleModel[] albums = searchAlbumService.requestSearchAlbum("Hello");
        for (AlbumSimpleModel album: albums) {
            System.out.println(album.getAlbumName());
        }
        assertNotEquals(albums.length, 0);
    }
}