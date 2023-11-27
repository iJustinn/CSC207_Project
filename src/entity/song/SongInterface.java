package entity.song;


import java.util.ArrayList;

public interface SongInterface {
    public String getTitle();

    public void setTitle(String title);

    public ArrayList<String> getArtist();

    public String getAlbum();

    public void setAlbum(String album);

    public String getId();

    public String getComment();

    public void setComment(String comment);
}
