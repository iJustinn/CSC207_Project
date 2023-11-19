package entity.User;

public class UserProfile {
    private final String username;

    private final String comments;


    public UserProfile(String username, String password, String comments) {
        this.username = username;
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public String getComments() {return comments;}
}
