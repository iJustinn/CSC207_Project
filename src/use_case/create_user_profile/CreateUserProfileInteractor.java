package use_case.create_user_profile;

import entity.UserSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CreateUserProfileInteractor implements CreateUserProfileInputBoundary {
    private final CreateUserProfileDataAccessInterface userProfileDataAccessObject;
    private final CreateUserProfileOutputBoundary userProfilePresenter;

    public CreateUserProfileInteractor(CreateUserProfileDataAccessInterface userProfileDataAccessInterface,
                                       CreateUserProfileOutputBoundary userProfileOutputBoundary) {
        this.userProfileDataAccessObject = userProfileDataAccessInterface;
        this.userProfilePresenter = userProfileOutputBoundary;
    }

    @Override
    public void execute(CreateUserProfileInputData createProfileInputData) {
        String currentUserId = UserSession.getInstance().getCurrentUser().getName();
        LocalDateTime now = LocalDateTime.now();

        try {
            userProfileDataAccessObject.createUserProfile(currentUserId, createProfileInputData.getProfileInformation());
            CreateUserProfileOutputData outputData = new CreateUserProfileOutputData(true, "Profile created successfully", Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
            userProfilePresenter.present(outputData);
        } catch (IOException e) {
            CreateUserProfileOutputData outputData = new CreateUserProfileOutputData(false, "Failed to create profile", null);
            userProfilePresenter.present(outputData);
        }
    }
}
