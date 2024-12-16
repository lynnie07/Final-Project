import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MusicAppUI extends MusicApp {
    private static User user = new User("Linh", "password123");
    private static SimpleAudioPlayer audioPlayer;

    public static void main(String[] args) {
        userLogin();
    }

    private static void userLogin() {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter Username:");
            String password = JOptionPane.showInputDialog("Enter Password:");

            if (user.logIn(username, password)) {
                JOptionPane.showMessageDialog(null, "Welcome " + username + "!");
                createAndShowUI();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials. Try again.");
            }
        }
    }

    private static void createAndShowUI() {
        JFrame mainFrame = new JFrame("Music Library");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 400);
        mainFrame.setLayout(new FlowLayout());

        JLabel artistLabel = new JLabel("Choose an artist:");
        String[] artists = {"Rosé", "Jennie", "Lisa", "Jisoo", "BLACKPINK"};
        JComboBox<String> artistDropdown = new JComboBox<>(artists);

        JLabel songLabel = new JLabel("Choose a song:");
        JComboBox<String> songDropdown = new JComboBox<>();

        JButton addButton = new JButton("Add to Library");
        JButton libraryButton = new JButton("Go to Library");

        artistDropdown.addActionListener(e -> {
            songDropdown.removeAllItems();
            String selectedArtist = (String) artistDropdown.getSelectedItem();
            if (selectedArtist != null) {
                switch (selectedArtist) {
                    case "Rosé" -> {
                        songDropdown.addItem("Toxic till the end");
                        songDropdown.addItem("APT");
                        songDropdown.addItem("Drinks or coffee");
                    }
                    case "Jennie" -> {
                        songDropdown.addItem("Solo");
                        songDropdown.addItem("Mantra");
                        songDropdown.addItem("You and Me");
                    }
                    case "Lisa" -> {
                        songDropdown.addItem("Money");
                        songDropdown.addItem("New Woman");
                        songDropdown.addItem("Rockstar");
                    }
                    case "Jisoo" -> {
                        songDropdown.addItem("Flower");
                        songDropdown.addItem("All Eyes On Me");
                    }
                    case "BLACKPINK" -> {
                        songDropdown.addItem("DDU-DU DDU-DU");
                        songDropdown.addItem("Shut Down");
                        songDropdown.addItem("Yeah Yeah Yeah");
                    }
                }
            }
        });

        addButton.addActionListener(e -> {
            String selectedSong = (String) songDropdown.getSelectedItem();
            if (selectedSong != null && !userLibrary.contains(selectedSong)) {
                userLibrary.add(selectedSong);
                JOptionPane.showMessageDialog(mainFrame, "Added to Library: " + selectedSong);
            }
        });

        libraryButton.addActionListener(e -> showLibrary());

        mainFrame.add(artistLabel);
        mainFrame.add(artistDropdown);
        mainFrame.add(songLabel);
        mainFrame.add(songDropdown);
        mainFrame.add(addButton);
        mainFrame.add(libraryButton);
        mainFrame.setVisible(true);
    }

    private static void showLibrary() {
        JFrame libraryFrame = new JFrame("Your Library");
        libraryFrame.setSize(400, 300);

        JTextArea libraryDisplay = new JTextArea();
        libraryDisplay.setEditable(false);

        libraryDisplay.append("Instructions:\nPress 'Enter' to show song info\nDouble-click to play a song\n\n");

        for (String song : userLibrary) {
            libraryDisplay.append(song + "\n");
        }

        // Mouse listener for double-click to play a song
        libraryDisplay.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int offset = libraryDisplay.viewToModel(e.getPoint());
                    try {
                        String selectedSong = libraryDisplay.getText()
                                .split("\n")[libraryDisplay.getLineOfOffset(offset)].trim();
                        playSong(selectedSong);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Key listener to show song info when 'Enter' is pressed
        libraryDisplay.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        int caretPosition = libraryDisplay.getCaretPosition();
                        int lineStart = libraryDisplay.getLineStartOffset(libraryDisplay.getLineOfOffset(caretPosition));
                        int lineEnd = libraryDisplay.getLineEndOffset(libraryDisplay.getLineOfOffset(caretPosition));
                        String selectedSong = libraryDisplay.getText().substring(lineStart, lineEnd).trim();

                        if (!selectedSong.isEmpty()) {
                            showSongInfo(selectedSong);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        libraryFrame.add(new JScrollPane(libraryDisplay));
        libraryFrame.setVisible(true);
    }

    private static void showSongInfo(String songName) {
        Song song = songInfo.get(songName); // Fetch song info from MusicApp
        if (song != null) {
            JOptionPane.showMessageDialog(null,
                    "Song Info:\nTitle: " + song.getTitle() +
                            "\nArtist: " + song.getArtist() +
                            "\nGenre: " + song.getGenre(),
                    "Song Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No information available for this song.");
        }
    }

    private static void playSong(String songName) {
        String filePath = songPaths.get(songName);
        if (filePath != null) {
            try {
                if (audioPlayer != null) {
                    audioPlayer.stop();
                }
                audioPlayer = new SimpleAudioPlayer(filePath);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error playing song: " + songName);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Song file not found.");
        }
    }
}


