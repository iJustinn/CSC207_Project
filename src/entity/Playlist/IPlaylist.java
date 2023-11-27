package entity.Playlist;

import java.util.Date;
import java.util.HashMap;
import entity.song.Song;

public interface IPlaylist {
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
