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
 * Creates Admin Login screen
 * extends the Default screen components
 * and implements the ActionListener interface
 * to handle button clicks
 */
public class AdminLogin extends DefaultScreen implements ActionListener {

    /**The main JPanel of the JFrame**/
    JPanel pane;

    /**JButton that will be used to check criteria of admin **/
    JButton submit;

    /**A button that will be used to go back to the previous screen */
    JButton back;

    /**text fields that will let the admin type in username and password.**/
    JTextField user, password;

    /**
     * Constructor for the AdminLogin
     *
     */
    public AdminLogin(){

        super();
        /**set the size of the JFrame**/
        this.setPreferredSize(new Dimension(900, 600));

        /**Set the title of the JFrame**/
        this.setTitle("Admin Login");

        /**Set the JFrame to visible**/
        this.setVisible(true);

        /**set user equal to admin**/
        user = new JTextField("admin");

        /**set password equal to admin**/
        password = new JTextField("admin");


        pane = new JPanel();

        /**add the pane to the defp JFrame at the BorderLayout Center**/
        defp.add(pane, BorderLayout.CENTER);
        pane.setOpaque(false);

        /**set the layout of pane to a GridBagLayout**/
        pane.setLayout(new GridBagLayout());

        /**Set the GridBagConstraints**/
        GridBagConstraints con = new GridBagConstraints();

        /**set up the layout for the Gridbag**/
        setupButtons(con, pane, submit, user, password, back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    /**
     *
     * A setUpButtons method to setup the buttons to use in the GridBagLayout
     *
     * @param con constraints for GridBagLayout
     * @param pane the pane for the layout to appear
     * @param submit submit button
     * @param user username
     * @param password password
     * @param back back button
     */
    private void setupButtons(GridBagConstraints con, JPanel pane, JButton submit, JTextField user, JTextField password,
                               JButton back) {


        /**sets the JLabel userName to say User Name: **/
        JLabel userName = new JLabel("User Name: ");
        //place the GridBagConstraints Horizontally
        con.fill = GridBagConstraints.HORIZONTAL;
        //The weight of the label
        con.weightx = 0.25;
        //the position of the label in the GridBagLayout on the X-axis
        con.gridx = 0;
        //the position of the label in the GridBagLayout on the Y-axis
        con.gridy = 0;
        //add the userName to the pane
        pane.add(userName, con);

        /**sets the text field userName to say Admin **/
        user = new JTextField("admin");
        //place the GridBagConstraints Horizontally
        con.fill = GridBagConstraints.HORIZONTAL;
        //The weight of the text field
        con.weightx = 0.25;
        //the position of the text field in the GridBagLayout on the X-axis
        con.gridx = 0;
        //the position of the text field in the GridBagLayout on the Y-axis
        con.gridy = 1;
        //add the user to the pane
        pane.add(user, con);


        /**sets the JLabel userPassword to say Password: **/
        JLabel userPassword = new JLabel("Password: ");
        //place the GridBagConstraints Horizontally
        con.fill = GridBagConstraints.HORIZONTAL;
        //The weight of the label
        con.weightx = 0.25;
        //the position of the label in the GridBagLayout on the X-axis
        con.gridx = 0;
        //the position of the label in the GridBagLayout on the Y-axis
        con.gridy = 2;
        //add the userPassword to the pane
        pane.add(userPassword, con);


        /**sets the text field password to say admin **/
        password = new JTextField("admin");
        con.fill = GridBagConstraints.HORIZONTAL;
        //The weight of the text field
        con.weightx = 0.25;
        //the position of the text field in the GridBagLayout on the X-axis
        con.gridx = 0;
        //the position of the text field in the GridBagLayout on the Y-axis
        con.gridy = 3;
        //add the password to the pane
        pane.add(password, con);

        /**sets the JButton submit to say submit and set the ActionCommand **/
        submit = new JButton("Submit");
        submit.setActionCommand("Submit");
        submit.addActionListener(this);
        con.fill = GridBagConstraints.HORIZONTAL;
        //The weight of the button
        con.weightx = .25;
        //the position of the button in the GridBagLayout on the X-axis
        con.gridx = 0;
        //the position of the button in the GridBagLayout on the Y-axis
        con.gridy = 4;
        //add the submit to the pane
        pane.add(submit, con);

        /**sets the JButton back to say Back and set the ActionCommand **/
        back = new JButton("Back");
        back.setActionCommand("Back");
        back.addActionListener(this);
        con.fill = GridBagConstraints.HORIZONTAL;
        //The weight of the button
        con.weightx = .25;
        //the position of the button in the GridBagLayout on the X-axis
        con.gridx = 1;
        //the position of the button in the GridBagLayout on the Y-axis
        con.gridy = 4;
        //add the user to the pane
        pane.add(back, con);

        //sets the grid width to 6
        con.gridwidth = 6;
        //sets the grid height to 6
        con.gridheight= 6;
    }

    /**
     * Listens for the click of the button
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /**sets a Object command equal to the getActionCommand**/
        Object command = ((JButton)e.getSource()).getActionCommand();
        /**sets an Array of Strings equal to an array of Strings at position 0**/
        String[] args = new String[0];
        /**If command equals Back then go back to the previous screen**/
        if(command.equals("Back")){
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        /**If command equals Submit then jump to the admin menu screen if the user and password equal admin**/
        if(command.equals("Submit")){
            if(user.getText().equals("admin") && password.getText().equals("admin")){
                AdminMenu.main(args);
                pane.setVisible(false);
                this.dispose();
            }
        }
    }



    public static void main(String[] args){
        AdminLogin admin = new AdminLogin();
    }


}
