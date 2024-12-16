import java.awt.FlowLayout;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleAudioPlayer {
    private Clip clip;

    public SimpleAudioPlayer(String filePath) throws Exception {
        File audioFile = new File(filePath);
        if (!audioFile.exists()) {
            throw new Exception("File not found: " + filePath);
        }

        AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
        clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
        setupControlUI();
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    private void setupControlUI() {
        JFrame controlFrame = new JFrame("Audio Controls");
        controlFrame.setSize(300, 100);
        controlFrame.setLayout(new FlowLayout());

        JButton pauseButton = new JButton("Pause");
        JButton resumeButton = new JButton("Resume");
        JButton stopButton = new JButton("Stop");

        pauseButton.addActionListener(e -> clip.stop());
        resumeButton.addActionListener(e -> clip.start());
        stopButton.addActionListener(e -> {
            stop();
            controlFrame.dispose();
        });

        controlFrame.add(pauseButton);
        controlFrame.add(resumeButton);
        controlFrame.add(stopButton);
        controlFrame.setVisible(true);
    }
}




