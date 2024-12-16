import java.util.ArrayList;
import java.util.HashMap;

public class MusicApp {
    protected static final ArrayList<String> userLibrary = new ArrayList<>();
    protected static final HashMap<String, String> songPaths = new HashMap<>();
    protected static final HashMap<String, Song> songInfo = new HashMap<>(); // Store song objects

    static {
        // Song Paths
        songPaths.put("Toxic till the end", "music/music1.wav");
        songPaths.put("APT", "music/music2.wav");
        songPaths.put("Drinks or coffee", "music/music3.wav");
        songPaths.put("Solo", "music/music4.wav");
        songPaths.put("Mantra", "music/music5.wav");
        songPaths.put("You and Me", "music/music6.wav");
        songPaths.put("Money", "music/music7.wav");
        songPaths.put("New Woman", "music/music8.wav");
        songPaths.put("Rockstar", "music/music9.wav");
        songPaths.put("Flower", "music/music10.wav");
        songPaths.put("All Eyes On Me", "music/music11.wav");
        songPaths.put("DDU-DU DDU-DU", "music/music12.wav");
        songPaths.put("Shut Down", "music/music13.wav");
        songPaths.put("Yeah Yeah Yeah", "music/music14.wav");


        // Adding song info
        songInfo.put("Toxic till the end", new Song("Toxic till the end", "Rosé", "Pop"));
        songInfo.put("APT", new Song("APT", "Rosé", "Pop"));
        songInfo.put("Drinks or coffee", new Song("Drinks or coffee", "Rosé", "Acoustic"));
        
        songInfo.put("Solo", new Song("Solo", "Jennie", "K-pop"));
        songInfo.put("Mantra", new Song("Mantra", "Jennie", "Pop"));
        songInfo.put("You and Me", new Song("You and Me", "Jennie", "Pop"));
        
        songInfo.put("Money", new Song("Money", "Lisa", "Hip-hop"));
        songInfo.put("New Woman", new Song("New Woman", "Lisa", "Rap"));
        songInfo.put("Rockstar", new Song("Rockstar", "Lisa", "Rap"));
        
        songInfo.put("Flower", new Song("Flower", "Jisoo", "K-pop"));
        songInfo.put("All Eyes On Me", new Song("All Eyes On Me", "Jisoo", "Pop"));
        
        songInfo.put("DDU-DU DDU-DU", new Song("DDU-DU DDU-DU", "BLACKPINK", "K-pop"));
        songInfo.put("Shut Down", new Song("Shut Down", "BLACKPINK", "K-pop"));
        songInfo.put("Yeah Yeah Yeah", new Song("Yeah Yeah Yeah", "BLACKPINK", "Pop"));
    }
}



