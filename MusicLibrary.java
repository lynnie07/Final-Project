import java.util.ArrayList;

public class MusicLibrary {
    private ArrayList<User> users;
    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private ArrayList<Playlist> playlists;

    public MusicLibrary() {
        this.users = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.albums = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void createPlaylist(String name) {
        playlists.add(new Playlist(name));
    }

    public Playlist getPlaylistByName(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(name)) {
                return playlist;
            }
        }
        return null;
    }

    public void displayAllSongs() {
        System.out.println("Available Songs:");
        for (Song song : songs) {
            System.out.println("- " + song.getTitle() + " by " + song.getArtist());
        }
    }

    // Main method: Entry point for the program
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();

        // Step 1: Add users
        User user1 = new User("Alice", "001", "alice@example.com", "password123");
        library.addUser(user1);

        // Step 2: Add songs
        Song song1 = new Song("Shape of You", "Ed Sheeran", 2017, "Pop", 240);
        Song song2 = new Song("Blinding Lights", "The Weeknd", 2020, "Synthwave", 200);
        library.addSong(song1);
        library.addSong(song2);

        // Step 3: Display all songs
        library.displayAllSongs();

        // Step 4: Create an album
        Album album = new Album("Top Hits 2020");
        album.addSong(song1);
        album.addSong(song2);
        library.addAlbum(album);

        // Step 5: Create a playlist
        library.createPlaylist("My Favorites");
        Playlist playlist = library.getPlaylistByName("My Favorites");
        if (playlist != null) {
            playlist.addToPlaylist(song1);
            playlist.addToPlaylist(song2);
        }

        // Step 6: Play a song
        song1.playSong();

        // Step 7: Shuffle and play the playlist
        if (playlist != null) {
            playlist.shufflePlay();
        }

        // Step 8: Display playlist contents
        System.out.println("Songs in playlist \"My Favorites\":");
        if (playlist != null) {
            for (Song song : playlist.getPlaylistSongs()) {
                System.out.println("- " + song.getTitle());
            }
        }
    }
}

