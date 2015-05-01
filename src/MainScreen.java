import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Trent Weatherman
 * @author Nicholas Widener
 * @author Austin Richburg
 * @author Jameson Burchette
 *
 * @version April 2015
 *
 * Creates the main screen for JukeMeister
 * Extends Default screen and implements the
 * ActionListener interface so buttons can be clicked
 */
public class MainScreen extends DefaultScreen implements ActionListener{

    /**
     * Constructs main screen
     */
    public MainScreen(){
        super();
    }

    /**
     * Action performed
     * @param event event performed
     */
    @Override
    public void actionPerformed(ActionEvent event){

    }

    /**
     * Main method to start the screen
     * @param args
     */
    public static void main(String[] args){
        //create new mainscreen
        MainScreen mainscreen = new MainScreen();

        //go
        mainscreen.go();

        //set mainscreen visible
        mainscreen.setVisible(true);
    }

    /**
     * Method to hold the main screen image
     * and sets clickable
     */
    public void go() {

        //Image for screen
        ImgPanel img = new ImgPanel();
        //button
        JButton button = new JButton();

        //button clickable
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String[] args = new String[0];
                HomeScreen.main(args);
            }
        });
        //set button size
        button.setPreferredSize(new Dimension(800, 600));
        //button opaque
        button.setOpaque(false);
        //fill content area
        button.setContentAreaFilled(false);
        //set no border
        button.setBorderPainted(false);
        //add button to image
        img.add(button);
        //add image to the layout
        add(img);
        button.setFocusPainted(false);
    }

}
