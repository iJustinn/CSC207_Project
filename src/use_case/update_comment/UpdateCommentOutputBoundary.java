package use_case.update_comment;

public interface UpdateCommentOutputBoundary {
    void prepareSuccessView(String success);

    void prepareFailView(String success);
}
