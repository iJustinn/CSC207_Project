package use_case.view_song;

import entity.Song.Song;
import use_case.view_playlists.ViewPlaylistsInputBoundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewSongInteractor implements ViewSongInputBound {
    final ViewSongDataAccess viewSongDataAccess;
    final ViewSongOutputBound presenter;


    public ViewSongInteractor(ViewSongDataAccess viewSongDataAccess, ViewSongOutputBound presenter) {
        this.viewSongDataAccess = viewSongDataAccess;
        this.presenter = presenter;
    }


    @Override
    public void execute(String user, ViewSongInputData viewSongInputData) throws IOException {
        HashMap<String, Song> map = viewSongDataAccess.getSongsByPlaylistName(user, viewSongInputData.getPlaylistName());
        // Convert this map into the DTO Song type
        ArrayList<SongDTO> songs = new ArrayList<>();
        for (Song i: map.values()){
            SongDTO song = new SongDTO(i.getTitle(), i.getId(), i.getArtist(), i.getAlbum(), i.getComment());
            songs.add(song);
        }

        ViewSongOutputData viewSongOutputData = new ViewSongOutputData(songs);
        presenter.prepareSuccessView(viewSongOutputData);
    }
}
