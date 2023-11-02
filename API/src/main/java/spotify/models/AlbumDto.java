package spotify.models;

public class AlbumDto {

    private final String id;
    private final String albumName;
    private final String releaseDate;

    public AlbumDto(String id, String album, String releaseDate) {
        this.id = id;
        this.albumName = album;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
