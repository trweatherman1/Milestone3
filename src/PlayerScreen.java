import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;

/**
 * Created by Jameson on 4/30/2015.
 */
public class PlayerScreen extends JFrame {
    private MusicPlayer musicPlayer;

    public PlayerScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        JPanel panel = new JPanel();

        musicPlayer = new MusicPlayer();
        musicPlayer.queueSong(new SongRecordModel("Semi-Charmed Life", "Third Eye Blind", "Third Eye Blind", "Rock"));
        musicPlayer.queueSong(new SongRecordModel("Finn Balor", "", "", ""));
        panel.add(musicPlayer.getJComponent());

        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PlayerScreen();
    }
}
