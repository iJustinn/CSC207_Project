package entity.Playlist;

import entity.song.Song;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Playlist implements Iterable<Song> {
    private String name;
    private int numberOfSongs;
    private Date date;
    private HashMap<String, Song> songs;

    // Default constructor for Jackson
    public Playlist() {
        this.songs = new HashMap<>();
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

    // Iterable interface implementation
    @Override
    public Iterator<Song> iterator() {
        return new SongIterator();
    }

    // Inner class to implement the Iterator interface
    private class SongIterator implements Iterator<Song> {
        private Iterator<Song> songIterator;

        public SongIterator() {
            this.songIterator = songs.values().iterator();
        }

        @Override
        public boolean hasNext() {
            return songIterator.hasNext();
        }

        @Override
        public Song next() {
            return songIterator.next();
        }

        // Optional: Implement the remove method if you want to allow
        // removal of songs during iteration
        @Override
        public void remove() {
            songIterator.remove();
        }
    }
}
