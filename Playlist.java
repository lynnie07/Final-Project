import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> musicLibraryList;

    public Playlist(String name) {
        this.name = name;
        this.musicLibraryList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addToPlaylist(Song song) {
        musicLibraryList.add(song);
    }

    public void removeFromPlaylist(Song song) {
        musicLibraryList.remove(song);
    }

    public void shufflePlay() {
        System.out.println("Shuffling and playing playlist: " + name);
    }

    public ArrayList<Song> getPlaylistSongs() {
        return musicLibraryList;
    }
}
