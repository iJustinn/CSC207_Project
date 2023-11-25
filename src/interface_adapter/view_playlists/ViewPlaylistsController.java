package interface_adapter.view_playlists;

import use_case.view_playlists.ViewPlaylistsInputBoundary;

import java.io.IOException;

public class ViewPlaylistsController {
    final ViewPlaylistsInputBoundary viewPlaylistsInteractor;

    public ViewPlaylistsController(ViewPlaylistsInputBoundary viewPlaylistsInteractor) {
        this.viewPlaylistsInteractor = viewPlaylistsInteractor;
    }

    public void execute() throws IOException {
        viewPlaylistsInteractor.execute();
    }
}
