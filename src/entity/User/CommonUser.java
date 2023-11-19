package entity.User;

import java.time.LocalDateTime;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;

    private final UserDatabase Database;

    private final UserProfile userProfile;

    /**
     * Requires: password is valid.
     *
     * @param name
     * @param password
     * @param database
     * @param userProfile
     */
    CommonUser(String name, String password, LocalDateTime creationTime, UserDatabase database, UserProfile userProfile) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.Database = database;
        this.userProfile = userProfile;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public UserDatabase getDatabase(){return Database;}

    @Override
    public UserProfile getUserProfile(){return userProfile;}
}
