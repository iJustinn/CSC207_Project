package entity.User;

import java.time.LocalDateTime;

public interface User {

    String getName();

    String getPassword();

    LocalDateTime getCreationTime();

    UserDatabase getDatabase();

    UserProfile getUserProfile();
}
