package entity;

import java.util.ArrayList;

public class Album {
    private final String name;

    private final String releaseDate;

    private final String id;

    private final ArrayList<Artist> artists;


    public Album(String name, String releaseDate, String id, ArrayList<Artist> artists) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.id = id;
        this.artists = artists;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }
}
