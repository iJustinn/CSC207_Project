// Playlist.java in package entity

package entity;

import java.util.Date;
import java.util.Map;

public class Playlist {
    private String name;
    private int numberOfSongs;
    private Date date;
    private Map<Integer, Song> songs;

    // Constructor
    public Playlist(String name, int numberOfSongs, Date date, Map<Integer, Song> songs) {
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

    public Map<Integer, Song> getSongs() {
        return songs;
    }

    public void setSongs(Map<Integer, Song> songs) {
        this.songs = songs;
    }

    public void getSong() {

    }

    public void addSong(Song song) {
        this.songs.put(this.songs.size() + 1, song);
        this.numberOfSongs = this.songs.size();
    }
}
