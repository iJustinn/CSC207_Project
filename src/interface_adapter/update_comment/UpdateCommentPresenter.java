package interface_adapter.update_comment;

import use_case.update_comment.UpdateCommentOutputBoundary;

public class UpdateCommentPresenter implements UpdateCommentOutputBoundary {
    private UpdateCommentViewModel viewModel;

    public UpdateCommentPresenter(UpdateCommentViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(String successMessage) {
        viewModel.setCommentUpdateStatus(successMessage);
    }

    @Override
    public void prepareFailView(String successMessage){

    }
}
