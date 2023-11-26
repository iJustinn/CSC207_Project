package data_access;


import entity.album.*;
import entity.artist.*;
import entity.song.*;

import spotify.SpotifyEndpoint;
import spotify.models.*;

import use_case.search.SearchDataAccessInterface;
import use_case.get_by_id.GetByIdDataAccessInterface;

import java.util.List;

/**
 * A DataAccessObject used to get data from the Spotify API
 */
public class SpotifyDataAccessObject implements SearchDataAccessInterface, GetByIdDataAccessInterface {
    private final SpotifyEndpoint spotifyApi;

    public SpotifyDataAccessObject(SpotifyEndpoint spotifyApi) {
        this.spotifyApi = spotifyApi;
    }


    @Override
    public List<? extends IAlbumSimple> searchAlbumsByName(String albumName) {
        try {
            List<AlbumSimpleModel> albums = spotifyApi.searchAlbum(albumName);
            return albums.stream().map(AlbumSimple::new).toList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<? extends IArtistFull> searchArtistByName(String artistName) {
        try {
            List<ArtistModel> artists = spotifyApi.searchArtist(artistName);
            return artists.stream().map(ArtistFull::new).toList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<? extends ISongFull> searchSongByName(String songName) {
        try {
            List<TrackModel> songs = spotifyApi.searchTrack(songName);
            return songs.stream().map(SongFull::new).toList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public IAlbumFull getAlbumById(String albumId) {
        return null;
    }

    @Override
    public IArtistFull getArtistById(String artistId) {
        return null;
    }

    @Override
    public ISongFull getSongById(String songId) {
        return null;
    }
}
