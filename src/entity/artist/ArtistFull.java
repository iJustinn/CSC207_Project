package entity.artist;

public interface ArtistFull extends ArtistSimple {
    String[] getGenres();
    Integer getPopularity();
}
