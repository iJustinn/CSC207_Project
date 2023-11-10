package use_case.search.search_artist;

import entity.artist.Artist;

public class SearchArtistOutputData {
    private final Artist[] artists;

    public SearchArtistOutputData(Artist[] artists) {
        this.artists = artists;
    }

    public Artist[] getArtists() {
        return artists;
    }
}
