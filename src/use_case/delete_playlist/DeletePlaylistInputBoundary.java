package use_case.delete_playlist;


import java.io.IOException;

public interface DeletePlaylistInputBoundary {

    void execute(DeletePlaylistInputData deletePlaylistInputData) throws IOException;
}
