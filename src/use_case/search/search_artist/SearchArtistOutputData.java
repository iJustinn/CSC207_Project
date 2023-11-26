package use_case.search.search_artist;

import entity.artist.IArtistFull;

import java.util.List;

public class SearchArtistOutputData {
    private final List<? extends IArtistFull> artists;

    public SearchArtistOutputData(List<? extends IArtistFull> artists) {
        this.artists = artists;
    }

    public List<? extends IArtistFull> getArtists() {
        return artists;
    }
}
