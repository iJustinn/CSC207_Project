package use_case.get_album_songs;

import entity.song.Song;

import java.util.List;

public class GetAlbumSongsInteractor implements GetAlbumSongsInputBoundary {
    private final GetAlbumSongsDataAccessInterface repository;
    private final GetAlbumSongsOutputBoundary presenter;

    public GetAlbumSongsInteractor(GetAlbumSongsDataAccessInterface repository,
                                   GetAlbumSongsOutputBoundary presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public void execute(GetAlbumSongsInputData input) {
        String id = input.getInput();
        List<Song> songs = repository.getAlbumSongs(id);
        GetAlbumSongsOutputData output = new GetAlbumSongsOutputData(songs);
        presenter.success(output);
    }
}
