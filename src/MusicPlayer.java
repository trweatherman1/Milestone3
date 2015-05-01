import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.LinkedList;

/**
 * Created by Jameson on 4/28/2015.
 */
public class MusicPlayer {
    private MusicPlayerView view = new MusicPlayerView();
    private LinkedList<SongRecordModel> songQueue;
    private LinkedList<MediaPlayer> playerQueue;
    private boolean songPlaying;

    public MusicPlayer () {
        songQueue = new LinkedList();
        playerQueue = new LinkedList();
        songPlaying = false;
    }

    public void queueSong(final SongRecordModel song) {
        final JFXPanel jfxPanel = new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MediaPlayer player = new MediaPlayer(new Media(this.getClass().getResource(song.getSong() + ".mp3").toString()));
                    player.setOnEndOfMedia(new Runnable() {
                        @Override
                        public void run() {
                            playNext();
                        }
                    });
                    playerQueue.add(player);
                } catch (NullPointerException NPE) {
                    try {
                        MediaPlayer player = new MediaPlayer(new Media(this.getClass().getResource(song.getSong() + ".wav").toString()));
                        player.setOnEndOfMedia(new Runnable() {
                            @Override
                            public void run() {
                                playNext();
                            }
                        });
                        playerQueue.add(player);
                    } catch (Exception e) {
                        System.out.println("Could not play song " + song.getSong());
                        return;
                    }
                }
                songQueue.add(song);
                if (!songPlaying)
                    playNext();
            }
        });

    }

    public void playNext() {
        SongRecordModel next = songQueue.poll();
        if (next != null) {
            view.setSong(next);
            playerQueue.poll().play();
            songPlaying = true;
        }
        else
            songPlaying = false;
    }

    public boolean isSongPlaying() {return songPlaying;}

    public JFXPanel getJComponent() {
        final JFXPanel jfxPanel = new JFXPanel();
        final MusicPlayerView mpv = view;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(jfxPanel, mpv.makeScene());
            }
        });
        return jfxPanel;
    }

    private void initFX(JFXPanel jfxPanel, Scene scene) {
        jfxPanel.setScene(scene);
    }
}
