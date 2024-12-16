public class Song extends MusicLibrary {
    private String genre;
    private int duration;

    public Song(String title, String artist, int releaseYear, String genre, int duration) {
        super(title, artist, releaseYear);
        this.genre = genre;
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public void playSong() {
        System.out.println("Playing song: " + getTitle());
    }

    public void pauseSong() {
        System.out.println("Pausing song: " + getTitle());
    }
}
