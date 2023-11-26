package use_case.view_song;

import java.util.ArrayList;

public class SongDTO {

    private String id;
    private String title;
    private ArrayList<String> artist;
    private String album;
    private String comment;

    public SongDTO(String title, String id, ArrayList<String> artist, String album, String comment){
        this.title = title;
        this.id = id;
        this.artist = artist;
        this.album = album;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public ArrayList<String> getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
