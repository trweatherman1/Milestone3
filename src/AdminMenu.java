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
 * Creates Admin Menu options screen
 * extends the Default screen components
 * and implements the ActionListener interface
 * to handle button clicks
 */
public class AdminMenu extends DefaultScreen implements ActionListener {

    /**The main JPanel of the JFrame**/
    JPanel pane = new JPanel();

    /**The JPanel that will go into the center of pane**/
    JPanel center = new JPanel();

    /**The JPanel that will go into the center of pane**/
    JPanel west = new JPanel();

    /*JButtons that the user will press to change screens n the admin menu**/
    JButton setPrice, usageStats, updateLibrary, other, logout;

    /**
     * A constructor for the AdminMenu to set up the JPanels
     *
     */
    public AdminMenu(){
        super();
        pane.setOpaque(false);

        /**Add pane to the defp Frame**/
        defp.add(pane);

        /****/
        pane.setLayout(new BorderLayout());
        center.setOpaque(false);

        /**set the center JPanel to be a Box layout along the y-axis**/
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        west.setOpaque(false);

        /**set the west JPanel to be a FlowLayout**/
        west.setLayout(new FlowLayout());

        /**Add the center JPanel to the pane at the Center BorderLayout**/
        pane.add(center, BorderLayout.CENTER);

        /**Add the west JPanel to the pane at the West BorderLayout**/
        pane.add(west, BorderLayout.WEST);

        //add glue to the first layer of center pane
        center.add(Box.createGlue());

        //add the setPriceButton to the center pane
        this.setPriceButton(center);

        //add glue to the first layer of center pane
        center.add(Box.createGlue());

        //add the usageStatsButton to the center pane
        this.usageStatsButton(center);

        //add glue to the first layer of center pane
        center.add(Box.createGlue());

        //add the updateLibraryButton to the center pane
        this.updateLibraryButton(center);

        //add glue to the first layer of center pane
        center.add(Box.createGlue());

        //add the otherButton to the center pane
        this.otherButton(center);

        //add glue to the first layer of center pane
        center.add(Box.createGlue());

        //add the logoutButton to the center pane
        this.logoutButton(west);

        /**sets the action command for the setPriceButton**/
        setPrice.setActionCommand("Set Price");

        /**sets the action command for the usageStatisticsButton**/
        usageStats.setActionCommand("Usage Statistics");

        /**sets the action command for the updateLibraryButton**/
        updateLibrary.setActionCommand("Update Library");

        /**sets the action command for the otherButton**/
        other.setActionCommand("Other Features");

        /**set the size of the JFrame**/
        this.setPreferredSize(new Dimension(900,600));

        /**Set the title of the screen**/
        this.setTitle("Admin Menu");

        /**set the JFrame visible**/
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * A method that sets up the setPriceButton with it's text, size, and the action listener.
     *
     *
     * @param pane pane the button is held in
     */
    public void setPriceButton(JPanel pane){
        setPrice = new JButton();
        setPrice.setName("Set Price");
        setPrice.setLabel("Set Price");
        //System.out.println("Set Price");
        setPrice.setPreferredSize(new Dimension(100, 100));
        setPrice.setMaximumSize(new Dimension(200,300));
        setPrice.setAlignmentX(CENTER_ALIGNMENT);
        setPrice.addActionListener(this);
        pane.add(setPrice);
    }

    /**
     * A method that sets up the usageStatsButton with it's text, size, and the action listener.
     *
     *
     * @param pane pane the usage button is held in
     */
    public void usageStatsButton(JPanel pane){
        usageStats = new JButton();
        usageStats.setName("Usage Statistics");
        usageStats.setLabel("Usage Statistics");
        //System.out.println("Usage Statistics");
        usageStats.setPreferredSize(new Dimension(100, 100));
        usageStats.setMaximumSize(new Dimension(200,300));
        usageStats.setAlignmentX(CENTER_ALIGNMENT);
        usageStats.addActionListener(this);
        pane.add(usageStats);
    }

    /**
     * A method that sets up the updateLibraryButton with it's text, size, and the action listener.
     *
     *
     * @param pane pane the update library button is held in
     */
    public void updateLibraryButton(JPanel pane){
        updateLibrary = new JButton();
        updateLibrary.setName("Update Library");
        updateLibrary.setLabel("Update Library");
        //System.out.println("Update Library");
        updateLibrary.setPreferredSize(new Dimension(100, 100));
        updateLibrary.setMaximumSize(new Dimension(200,300));
        updateLibrary.addActionListener(this);
        updateLibrary.setAlignmentX(CENTER_ALIGNMENT);
        pane.add(updateLibrary);
    }

    /**
     * A method that sets up the otherButton with it's text, size, and the action listener.
     *
     *
     * @param pane
     */
    public void otherButton(JPanel pane){
        other = new JButton();
        other.setName("Other Features");
        other.setLabel("Other Features");
        //System.out.println("Other Features");
        other.setPreferredSize(new Dimension(100, 100));
        other.setMaximumSize(new Dimension(200,300));
        other.setAlignmentX(CENTER_ALIGNMENT);
        other.addActionListener(this);
        pane.add(other);
    }

    /**
     * A method that sets up the logoutButton with it's text, size, and the action listener.
     *
     *
     * @param pane pane the logout button is in
     */
    public void logoutButton(JPanel pane){
        logout = new JButton();
        logout.setName("Logout");
        logout.setLabel("Logout");
        logout.setFocusPainted(false);
        logout.setPreferredSize(new Dimension(100, 100));
        logout.addActionListener(this);
        pane.add(logout);

    }

    /**Listens for the click of the button
     *
     * @param e event
     *
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        /**sets a String command equal to the getActionCommand**/
        String command = ((JButton)e.getSource()).getActionCommand();

        /**sets an Array of Strings equal to an array of Strings at position 0**/
        String[] args = new String[0];

        /**If command equals Set Price then should jump to a set price screen**/
        if(command.equals("Set Price")){
            //System.out.println("Set Price");
        }
        /**If command equals Usage Statistics then should jump to a usage statistics screen**/
        else if(command.equals("Usage Statistics")){
            //System.out.println("Usage Stats");
        }
        /**If command equals Update Library then jump to a update Library screen**/
        else if(command.equals("Update Library")){
            //System.out.println("Update Library");
            SongDirectory.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        /**If command equals Other Features then jump to other features screen**/
        else if(command.equals("Other Features")){
            //System.out.println("Other Features");
            OtherFeatures.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        /**If command equals Logout then should jump to the home screen and logout the admin**/
        else if(command.equals("Logout")){
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    /**
     *
     * The method that runs this portion of the program
     * @param args
     */
    public static void main(String[] args){
        AdminMenu admin = new AdminMenu();
    }
}
