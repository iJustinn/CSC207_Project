package interface_adapter.update_comment;

import interface_adapter.create_playlist.CreatePlaylistState;
import use_case.update_comment.UpdateCommentOutputBoundary;

public class UpdateCommentPresenter implements UpdateCommentOutputBoundary {
    private UpdateCommentViewModel viewModel;

    public UpdateCommentPresenter(UpdateCommentViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void presentSuccess(String successMessage) {
        viewModel.setCommentUpdateStatus(successMessage, true);
    }

    @Override
    public void presentFailure(String errorMessage){
        viewModel.setCommentUpdateStatus(errorMessage, false);
    }

}
