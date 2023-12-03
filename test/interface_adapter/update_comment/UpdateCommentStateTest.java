package interface_adapter.update_comment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateCommentStateTest {

    @Test
    void setAndGetCommentUpdated() {
        UpdateCommentState state = new UpdateCommentState();
        state.setCommentUpdated(true);

        assertTrue(state.isCommentUpdated());
    }
}