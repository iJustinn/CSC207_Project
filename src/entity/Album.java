package entity;

public interface Album {
    String getId();
    String getName();
    String[] getGenres();
    Artist[] getArtists();
    String getReleaseDate();
}
