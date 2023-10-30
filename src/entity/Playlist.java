package entity;

import java.util.ArrayList;

public class Playlist {
    private final String name;
    private final String id;
    private final ArrayList<Song> songs;


    public Playlist(String name, String id, ArrayList<Song> songs) {
        this.name = name;
        this.id = id;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
