package spotify.services;

import org.junit.jupiter.api.Test;
import spotify.models.AlbumDto;

import static org.junit.jupiter.api.Assertions.*;

class SearchAlbumServiceTest {
    @Test
    void requestSearchAlbum() {
        SearchAlbumService searchAlbumService = new SearchAlbumService();
        AlbumDto[] albums = searchAlbumService.requestSearchAlbum("Hello");
        for (AlbumDto album: albums) {
            System.out.println(album.getAlbumName());
        }
        assertNotEquals(albums.length, 0);
    }
}