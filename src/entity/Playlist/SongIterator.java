package entity.Playlist;

import entity.song.Song;

import java.util.Iterator;
import java.util.HashMap;

public class SongIterator implements Iterator<Song> {
    private Iterator<Song> songIterator;

    public SongIterator(HashMap<String, Song> songs) {
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

}
