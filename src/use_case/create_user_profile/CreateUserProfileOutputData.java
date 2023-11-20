package use_case.create_user_profile;

public class CreateUserProfileOutputData {
    private final boolean success;
    private final String message;

    public CreateUserProfileOutputData(boolean success, String message) {
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
