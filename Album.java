import java.util.ArrayList;

public class Album {
    private String label;
    private int numberOfTracks;
    private ArrayList<Song> songList;

    public Album(String label) {
        this.label = label;
        this.songList = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public int getNumberOfTracks() {
        return songList.size();
    }

    public void addSong(Song song) {
        songList.add(song);
    }

    public ArrayList<Song> getSongs() {
        return songList;
    }
}
