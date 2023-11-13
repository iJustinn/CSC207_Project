package use_case.search.search_artist;

import entity.artist.ArtistFull;

public class SearchArtistOutputData {
    private final ArtistFull[] artists;

    public SearchArtistOutputData(ArtistFull[] artists) {
        this.artists = artists;
    }

    public ArtistFull[] getArtists() {
        return artists;
    }
}
