package use_case.search.search_artist;

import entity.artist.*;

import java.util.List;

public class SearchArtistOutputData {
    private final List<ArtistFull> artists;

    public SearchArtistOutputData(List<ArtistFull> artists) {
        this.artists = artists;
    }

    public List<ArtistFull> getArtists() {
        return artists;
    }
}
