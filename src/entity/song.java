package entity;

import javax.xml.namespace.QName;

public class song {
    private String name;
    private artist artist;

    song(String name, artist artist){
        this.name = name;
        this.artist = artist;
    }

    public entity.artist getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }
}
