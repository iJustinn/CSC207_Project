package entity.Playlist;

import entity.Song.Song;

import java.util.Date;
import java.util.HashMap;

public interface PlaylistInterface {
    public String getName();

    public void setName(String name);

    public int getNumberOfSongs();

    public void setNumberOfSongs(int numberOfSongs);

    public Date getDate();

    public void setDate(Date date);

    public HashMap<String, Song> getSongs();

    public void setSongs(HashMap<String, Song> songs);

    public void getSong();
}