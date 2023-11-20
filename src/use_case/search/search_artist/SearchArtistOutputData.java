package use_case.search.search_artist;

import entity.artist.IArtistSimple;

import java.util.List;

public class SearchArtistOutputData {
    private final List<IArtistSimple> artists;

    public SearchArtistOutputData(List<IArtistSimple> artists) {
        this.artists = artists;
    }

    public List<IArtistSimple> getArtists() {
        return artists;
    }
}
