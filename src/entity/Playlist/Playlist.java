// Playlist.java in package entity

package entity.Playlist;

import java.util.Date;
import java.util.HashMap;
import entity.song.Song;

public class Playlist implements IPlaylist {
    private String name;
    private int numberOfSongs;
    private Date date;
    private HashMap<String, Song> songs;
    public Playlist() {
        // this constructor is needed by Jackson
    }

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
