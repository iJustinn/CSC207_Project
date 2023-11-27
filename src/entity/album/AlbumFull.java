package entity.album;


import entity.artist.ArtistSimple;
import entity.song.Song;

import java.util.List;

public class AlbumFull implements IAlbumFull {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<ArtistSimple> getArtists() {
        return null;
    }

    @Override
    public String getReleaseDate() {
        return null;
    }

    @Override
    public String[] getGenres() {
        return new String[0];
    }

    @Override
    public Integer getPopularity() {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public List<Song> getTracklist() {
        return null;
    }
}
