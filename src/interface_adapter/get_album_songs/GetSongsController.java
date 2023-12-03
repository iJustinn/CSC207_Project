package interface_adapter.get_album_songs;

import use_case.get_album_songs.GetAlbumSongsInputBoundary;
import use_case.get_album_songs.GetAlbumSongsInputData;
import use_case.get_album_songs.GetAlbumSongsInteractor;

public class GetSongsController {
    final GetAlbumSongsInputBoundary interactor;

    public GetSongsController(GetAlbumSongsInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String id) {
        GetAlbumSongsInputData input = new GetAlbumSongsInputData(id);
        interactor.execute(input);
    }
}
