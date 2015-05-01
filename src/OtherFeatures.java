import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jameson on 4/22/2015.
 */
public class OtherFeatures extends DefaultScreen implements ActionListener{

    JPanel pane;

    MusicPlayer sp = new MusicPlayer();

    Stage stage;

    SongRecordModel song;

    public OtherFeatures() {
        pane = new JPanel(new BorderLayout());
        pane.setOpaque(false);
        addCenter(pane);
        addNorth(pane);
        display(pane);
        defp.add(pane);
        east();
    }

    public void east() {
        JButton b = new JButton("Play");
        b.addActionListener(this);
        pane.add(b, BorderLayout.EAST);
    }

    public void addCenter(JPanel pane) {
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(Box.createGlue());
        addToggleButton("Attract Mode", new Dimension(100, 100), center);
        center.add(Box.createGlue());
        addToggleButton("Screen Saver", new Dimension(100, 100), center);
        pane.add(center, BorderLayout.CENTER);
    }

    public void addNorth(JPanel pane) {
        JPanel north = new JPanel();
        north.setOpaque(false);
        north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
        addButton("Back", new Dimension(100, 100), north);
        north.add(Box.createGlue());
        north.add(new JLabel("Other Features"));
        north.add(Box.createGlue());
        pane.add(north, BorderLayout.NORTH);
    }

    public void addButton(String name, Dimension size, JPanel pane) {
        JButton button = new JButton(name);
        button.setPreferredSize(size);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(300,300));
        pane.add(button);
    }

    public void addToggleButton(String name, Dimension size, JPanel pane) {
        JToggleButton button = new JToggleButton(name);
        button.setPreferredSize(size);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(300,300));
        pane.add(button);
    }

    public void display(JPanel pane) {
        this.setPreferredSize(new Dimension(800, 600));
        this.setTitle("Update Library");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String[] args = new String[0];
        if (command.equals("Attract Mode"))
            System.out.println("attract mode");
        else if (command.equals("Screen Saver"))
            System.out.println("Screen Saver");
        else if (command.equals("Back")) {
            System.out.println("back");
            AdminMenu.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        else if (command.equals("Play")) {
            sp.queueSong(song);
        }
    }

    public static void main(String args[]) { new OtherFeatures(); }
}
