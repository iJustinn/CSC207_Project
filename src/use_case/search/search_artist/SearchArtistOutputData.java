package use_case.search.search_artist;

import entity.artist.IArtistFull;

import java.util.List;

public class SearchArtistOutputData {
    private final List<IArtistFull> artists;

    public SearchArtistOutputData(List<IArtistFull> artists) {
        this.artists = artists;
    }

    public List<IArtistFull> getArtists() {
        return artists;
    }
}
