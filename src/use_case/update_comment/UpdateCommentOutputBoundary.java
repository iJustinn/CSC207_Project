package use_case.update_comment;

public interface UpdateCommentOutputBoundary {
    void presentSuccess(String success);

    void presentFailure(String success);
}
