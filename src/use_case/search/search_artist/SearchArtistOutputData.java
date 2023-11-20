package use_case.search.search_artist;

import entity.artist.ArtistSimple;

import java.util.List;

public class SearchArtistOutputData {
    private final List<ArtistSimple> artists;

    public SearchArtistOutputData(List<ArtistSimple> artists) {
        this.artists = artists;
    }

    public List<ArtistSimple> getArtists() {
        return artists;
    }
}
