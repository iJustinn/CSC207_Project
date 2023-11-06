package use_case.search_album;

public class SearchAlbumInputData {
    private final String albumName;

    public SearchAlbumInputData(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }
}
