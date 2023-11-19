package entity.Song;

import entity.Artist;

import java.util.ArrayList;

public interface SongInterface {
    public String getTitle();

    public void setTitle(String title);

    public ArrayList<Artist> getArtist();

    public String getAlbum();

    public void setAlbum(String album);

    public String getId();
}
