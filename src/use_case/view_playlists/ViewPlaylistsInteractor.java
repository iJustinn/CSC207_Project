package use_case.view_playlists;

import java.io.IOException;
import java.util.ArrayList;

public class ViewPlaylistsInteractor implements ViewPlaylistsInputBoundary{
    final ViewPlaylistsDataUserAccessInterface viewPlaylistsDataUserAccessInterface;
    final ViewPlaylistsOutputBoundary viewPlaylistsPresenter;
    public ViewPlaylistsInteractor(ViewPlaylistsDataUserAccessInterface viewPlaylistsDataUserAccessInterface, ViewPlaylistsOutputBoundary viewPlaylistsPresenter) {
        this.viewPlaylistsDataUserAccessInterface = viewPlaylistsDataUserAccessInterface;
        this.viewPlaylistsPresenter = viewPlaylistsPresenter;
    }

    @Override
    public void execute() throws IOException {
       ArrayList<String> playlists = viewPlaylistsDataUserAccessInterface.viewPlaylists("local");
       ViewPlaylistsOutputData outData = new ViewPlaylistsOutputData(playlists);
       viewPlaylistsPresenter.prepareSuccessView(outData);
    }
    //This use case will be used to view the list of playlists


}
