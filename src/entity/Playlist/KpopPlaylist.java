package entity.Playlist;

import entity.song.Song;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class KpopPlaylist implements IPlaylist, Iterable<Song>{

    private String name;
    private int numberOfSongs;
    private Date date;
    private HashMap<String, Song> songs;

    // Default constructor for Jackson
    public KpopPlaylist() {
        this.songs = new HashMap<>();
    }

    // Constructor
    public KpopPlaylist(String name, int numberOfSongs, Date date, HashMap<String, Song> songs) {
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

    @Override
    public Iterator<Song> iterator() {
        return new SongIterator(songs);
    }
}
