package DataStorageExample;

public class Playlist {
    private String name;

    // Constructor for Jackson
    public Playlist(){}

    public Playlist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
