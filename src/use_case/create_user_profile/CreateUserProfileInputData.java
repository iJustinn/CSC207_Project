package use_case.create_user_profile;

public class CreateUserProfileInputData {
    private final String userId;
    private final String profileInformation;

    public CreateUserProfileInputData(String userId, String profileInformation) {
        this.userId = userId;
        this.profileInformation = profileInformation;
    }

    public String getUserId() {
        return userId;
    }

    public String getProfileInformation() {
        return profileInformation;
    }
}
