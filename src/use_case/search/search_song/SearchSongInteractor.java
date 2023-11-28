package use_case.search.search_song;

import use_case.search.SearchDataAccessInterface;
import entity.song.Song;
import java.util.List;

public class SearchSongInteractor implements SearchSongInputBoundary{
    final SearchDataAccessInterface dataAccess;
    final SearchSongOutputBoundary presenter;

    public SearchSongInteractor(SearchDataAccessInterface dataAccess,
                               SearchSongOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchSongInputData input) {
        String name = input.getInput();
        List<Song> songs = dataAccess.searchSongByName(name);
        SearchSongOutputData output = new SearchSongOutputData(songs);
        presenter.prepareSuccessView(output);
    }
}
