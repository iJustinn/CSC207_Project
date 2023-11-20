package use_case.add_comment;

import java.io.IOException;

public class AddCommentInteractor implements AddCommentInputBoundary{
    final AddCommentDataAccessInterface addCommentDataAccessObject;
    final AddCommentOutputBoundary addCommentPresenter;

    public AddCommentInteractor(AddCommentDataAccessInterface addCommentDataAccessObject, AddCommentOutputBoundary addCommentPresenter) {
        this.addCommentDataAccessObject = addCommentDataAccessObject;
        this.addCommentPresenter = addCommentPresenter;
    }

    @Override
    public void execute(AddCommentInputData addCommentInputData) throws IOException {
        addCommentDataAccessObject.addComment("local", addCommentInputData.getSong(), addCommentInputData.getComment());
        addCommentPresenter.prepareSuccessView("The comment was successfully added.");

    }
}
