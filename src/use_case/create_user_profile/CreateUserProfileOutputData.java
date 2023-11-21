package use_case.create_user_profile;

import java.util.Date;

public class CreateUserProfileOutputData {
    private final boolean success;
    private final String message;

    public CreateUserProfileOutputData(boolean success, String message, Date from) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
