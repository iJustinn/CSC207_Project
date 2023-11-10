// Playlist.java in package entity

package entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Playlist {
    private String name;
    private int numberOfSongs;
    private Date date;
    private HashMap<String, Song> songs;

    // Constructor
    public Playlist(String name, int numberOfSongs, Date date, HashMap<String, Song> songs) {
        this.name = name;
        this.numberOfSongs = numberOfSongs;
        this.date = date;
        this.songs = songs;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashMap<String, Song> getSongs() {
        return songs;
    }

    public void setSongs(HashMap<String, Song> songs) {
        this.songs = songs;
    }

    public void getSong() {

    }
}
