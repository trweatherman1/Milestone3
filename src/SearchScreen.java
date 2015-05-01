import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Trent Weatherman
 * @author Nicholas Widener
 * @author Austin Richburg
 * @author Jameson Burchette
 *
 * @version April 2015
 *
 *
 * Creates the search screen for JukeMeister
 * Extends Default screen and implements the
 * ActionListener interface so buttons can be clicked
 */
public class SearchScreen extends DefaultScreen implements ActionListener {
    JPanel pane; /**main panel for screen**/

    JPanel center; /**center panel for screen**/

    JButton search; /**search button**/

    JButton back; /**back button**/

    static JTextField text1; /**text field for search**/

    JLabel title; /**title for the screen**/

    Keyboard keyboard = new Keyboard(); /**create new keyboard**/

    /**
     * Creates the search screen
     */
    public SearchScreen() {
        //create the main panel
        pane = new JPanel();
        //create the text field for search
        text1 = new JTextField();
        //create the label for title
        title = new JLabel();
        //add the main panel to the default panel is default screen
        defp.add(pane);
        //set pane not opaque
        pane.setOpaque(false);
        //set size of text field
        text1.setPreferredSize(new Dimension(600, 50));
        //align it to center
        text1.setAlignmentX(Component.CENTER_ALIGNMENT);

        //set the layout for main panel
        pane.setLayout(new BorderLayout());

        //call to setup center elements
        setUpCenter();

        //add to main panel
        pane.add(center, BorderLayout.CENTER);
        //add to main panel
        pane.add(text1, BorderLayout.NORTH);

        //add keyboard to main panel
        pane.add(keyboard, BorderLayout.SOUTH);

        //set the size
        this.setSize(900, 600);
        this.setTitle("Search Screen");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Sets up the search songs button
     * @param pane the pane the button will be applied to
     */
    public void searchSongsButton(JPanel pane){
        search = new JButton();
        search.setName("Search Songs");
        search.setLabel("Search Songs");
        search.setAlignmentX(Component.CENTER_ALIGNMENT);
        //search.setPreferredSize(new Dimension(30, 100));
        search.addActionListener(this);
        pane.add(search);
    }

    /**
     * Sets up the back button
     * @param pane the pane the button will be applied to
     */
    public void backButton(JPanel pane){
        back = new JButton();
        back.setName("Back");
        back.setLabel("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setPreferredSize(new Dimension(100, 50));
        back.addActionListener(this);
        pane.add(back);
    }

    /**
     * Setup all of the elements that will be in the center
     * of BorderLayout
     */
    private void setUpCenter() {
        center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        title.setText("Search Songs");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(title);
        center.add(Box.createGlue());
        center.add(Box.createGlue());
        this.searchSongsButton(center);
        center.add(Box.createGlue());
        this.backButton(center);
        center.add(Box.createGlue());

        back.setActionCommand("Back");
    }


    /**
     * Handles actions taken with buttons
     * @param e the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String[] args = new String[0];
        if(command.equals("Back")){
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    /**
     * Runs the screen
     * @param args arguments
     */
    public static void main(String[] args) {
        SearchScreen ss = new SearchScreen();
    }
}
