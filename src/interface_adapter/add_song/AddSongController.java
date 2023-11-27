package interface_adapter.add_song;

import entity.Playlist.Playlist;
import entity.song.Song;
import use_case.add_song.AddSongInputBoundary;
import use_case.add_song.AddSongInputData;

import java.io.IOException;

public class AddSongController{
    final AddSongInputBoundary interactor;

    public AddSongController(AddSongInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(Playlist playlist, Song song) {
        AddSongInputData input = new AddSongInputData(playlist, song);
        try {
            interactor.execute(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
