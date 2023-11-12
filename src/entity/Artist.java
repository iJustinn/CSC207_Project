package entity;

public class Artist {
    private final String name;
    private final String id;


    public Artist(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
