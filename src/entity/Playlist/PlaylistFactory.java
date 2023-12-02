package entity.Playlist;

import entity.artist.ArtistSimple;
import entity.song.Song;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PlaylistFactory implements IPlaylistFactory {

    // This method creates a new Playlist with the given name and current date.
    // It initializes the Playlist with no songs.
    @Override
    public Playlist create(String name) {
        return new Playlist(name, 0, new Date(), new HashMap<>());
    }

    @Override
    public KpopPalylist kpop_create(String name) {
        HashMap<String, Song> kpopSongs = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("blackpink");
        Song song1 = new Song("How You Like That",list,"1", "Great KPop song");
        // Example: Adding Blackpink songs to the playlist
        kpopSongs.put("1", song1);
        kpopSongs.put("2", new Song("Ddu-Du Ddu-Du",list,"2", "Hit KPop track"));
        return new KpopPalylist("KPop - Blackpink", 2,new Date(), kpopSongs);
    }


}
