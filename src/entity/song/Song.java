// Song.java in package entity

package entity.song;


import java.util.ArrayList;

public class Song implements entity.song.SongInterface {
    private final String EMPTY_STRING = "";

    private String title;
    private ArrayList<String> artist;
    private String album;

    private String id;

    private String comment;

    // Constructor
    public Song(String title, ArrayList<String> artist, String album, String id) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.id = id;
        this.comment = EMPTY_STRING;
    }

    // No-argument constructor for Jackson
    public Song() {}

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}