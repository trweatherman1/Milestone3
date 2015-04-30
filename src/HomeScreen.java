import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/18/2015.
 */
public class HomeScreen extends DefaultScreen implements ActionListener{

    /*JButtons that the user will press to change screens**/
    JButton browse, search, admin, payment;


    /**
     * Constructor for the home screen that sets a BoxLayout along the Y_Axis and places the browse, search, admin and
     * payment buttons to the JFrame
     *
     */
    public HomeScreen(){
        defp.setVisible(true);
        defp.setLayout(new FlowLayout());
        defp.setLayout(new BoxLayout(defp, BoxLayout.Y_AXIS));
        defp.add(Box.createGlue());
        this.browseSongsButton(defp);
        defp.add(Box.createGlue());
        this.searchSongsButton(defp);
        defp.add(Box.createGlue());
        this.paymentButton(defp);
        defp.add(Box.createGlue());
        this.adminButton(defp);
        defp.add(Box.createGlue());

        /**sets the action command for the browse button**/
        browse.setActionCommand("Browse Songs");

        /**sets the action command for the search button**/
        search.setActionCommand("Search Songs");

        /**sets the action command for the admin button**/
        admin.setActionCommand("Admin");

        /**sets the action command for the payment button**/
        payment.setActionCommand("Payment");

        /**sets the preferred size of the JFrame**/
        this.setPreferredSize(new Dimension(900, 600));

        /**sets the title of the JFrame**/
        this.setTitle("Main Menu");

        /**set the JFrame visible**/
        this.setVisible(true);

        /**Exits the program when clicking on the close button**/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * A method that sets up the browse button with it's text, size, and the action listetener.
     *
     *
     * @param pane
     */
    public void browseSongsButton(JPanel pane){
        browse = new JButton();
        browse.setName("Browse Songs");
        browse.setLabel("Browse Songs");
        browse.setAlignmentX(Component.CENTER_ALIGNMENT);
        //System.out.println("Browse Songs");
        browse.setPreferredSize(new Dimension(100, 100));
        browse.setMaximumSize(new Dimension(200, 300));
        browse.addActionListener(this);
        pane.add(browse);
        browse.setFocusPainted(false);
    }

    /**
     * A method that sets up the search button with it's text, size, and the action listetener.
     *
     *
     * @param pane
     */
    public void searchSongsButton(JPanel pane){
        search = new JButton();
        search.setName("Search Songs");
        search.setLabel("Search Songs");
        //System.out.println("Search Songs");
        search.setAlignmentX(Component.CENTER_ALIGNMENT);
        search.setPreferredSize(new Dimension(100, 100));
        search.setMaximumSize(new Dimension(200, 300));

        search.addActionListener(this);
        pane.add(search);
    }

    /**
     * A method that sets up the admin button with it's text, size, and the action listetener.
     *
     *
     * @param pane
     */
    public void adminButton(JPanel pane){
        admin = new JButton();
        admin.setName("Admin");
        admin.setLabel("Admin");
        admin.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin.setPreferredSize(new Dimension(100, 100));
        admin.setMaximumSize(new Dimension(200, 300));
        admin.addActionListener(this);
        pane.add(admin);
    }

    /**
     * A method that sets up the payment button with it's text, size, and the action listetener.
     *
     *
     * @param pane
     */
    public void paymentButton(JPanel pane){
        payment = new JButton();
        payment.setName("Payment");
        payment.setLabel("Payment");
        payment.setAlignmentX(Component.CENTER_ALIGNMENT);
        payment.setPreferredSize(new Dimension(100, 100));
        payment.setMaximumSize(new Dimension(200, 300));
        payment.addActionListener(this);
        pane.add(payment);
    }

    /**Listens for the click of the button**/
    @Override
    public void actionPerformed(ActionEvent e) {
        /**sets a String command equal to the getActionCommand**/
        String command = ((JButton)e.getSource()).getActionCommand();

        /**sets an Array of Strings equal to an array of Strings at position 0**/
        String[] args = new String[0];

        /**If command equals Browse Songs then we jump to the BrowseSongs screen**/
        if(command.equals("Browse Songs")){
            //System.out.println("browse");
            BrowseSongs.main(args);
            defp.setVisible(false);
            dispose();//dispose of the current screen it is on
        }
        /**If command equals Search Songs then we jump to the SearchScreen**/
        else if(command.equals("Search Songs")){
            //System.out.println("search");
            SearchScreen.main(args);
            defp.setVisible(false);
            dispose();//dispose of the current screen it is on
        }
        /**If command equals Admin then we jump to the Admin screen**/
        else if(command.equals("Admin")){
            //System.out.println("admin");

            AdminLogin.main(args);
            defp.setVisible(false);
            dispose();//dispose of the current screen it is on
        }
        /**If command equals Payment then we jump to the PaymentScreen**/
        else if(command.equals("Payment")){
            //System.out.println("Payment");

            Payment.main(args);
            defp.setVisible(false);
            dispose();//dispose of the current screen it is on
        }
    }

    /**
     * A class that runs this screen
     * @param args
     */
    public static void main(String[] args){

        HomeScreen home = new HomeScreen();
    }
}
