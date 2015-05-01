import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/18/2015.
 */
public class Payment extends DefaultScreen implements ActionListener{
    /**The JPanel that will make up the JFram**/
    JPanel pane, center, south;

    /**A JTextfield that will be the text on the screen**/
    JTextField text;

    /**Buttons that will be set to go in the JPanels**/
    JButton quarter, dollar, back;

    /**The total amount of money entered into the machine**/
    double total;


    /**
     *
     * A constructor that builds the panels in the frame for the Payment Screen
     *
     */
    public Payment(){

        //pane is going to be the main panel
        pane = new JPanel();

        //center is going to be in the Center border layout
        center = new JPanel();

        //south is going to be in the South border layout
        south = new JPanel();

        //a text field
        text = new JTextField();

        //adding the pane to the frame defp
        defp.add(pane);

        //set the size of the text field
        text.setPreferredSize(new Dimension(150, 30));

        //set the layout of the pane to a border layout
        pane.setLayout(new BorderLayout());

        //set the center pane as a box layout along the y-axis
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        //set the south pane as a box layout along the x-axis
        south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));

        pane.add(center, BorderLayout.CENTER);
        pane.add(south, BorderLayout.SOUTH);

        //set the text to be the total
        text.setText("$ " + total);

        //add the JTextField text to the center pane
        center.add(text);

        //add glue to the first layer of south pane
        south.add(Box.createGlue());
        //add the quarterButton to the south pane
        this.quarterButton(south);
        //add glue to the first layer of south pane
        south.add(Box.createGlue());
        //add dollarButton to the south pane
        this.dollarButton(south);
        //add glue to the first layer of south pane
        south.add(Box.createGlue());
        //add backButton to the south pane
        this.backButton(south);
        //add glue to the first layer of south pane
        south.add(Box.createGlue());
        //set the background of the south pane to be Cyan
        south.setBackground(Color.CYAN);

        //set total to 0.00
        total = 0.00;

        //set pane opaque to false
        pane.setOpaque(false);
        //set center opaque to false
        center.setOpaque(false);
        //set south opaque to false
        south.setOpaque(false);
        //set the preferred size of the frame
        this.setPreferredSize(new Dimension(900, 600));
        //set the title of the screen
        this.setTitle("Payment Screen");
        //set the screen visible
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    /**
     * A method that sets up the quarterButton with it's text, size, and the action listener.
     *
     *
     * @param pane the pane the button will be added to
     */
    public void quarterButton(JPanel pane){
        quarter = new JButton();
        quarter.setName("Add Quarter");
        quarter.setLabel("Add Quarter");
        //System.out.println("Add Quarter");
        quarter.setPreferredSize(new Dimension(200, 100));
        quarter.addActionListener(this);
        pane.add(quarter);

    }

    /**
     * A method that sets up the dollarButton with it's text, size, and the action listener.
     *
     *
     * @param pane the pane the button will be addded to
     */
    public void dollarButton(JPanel pane){
        dollar = new JButton();
        dollar.setName("Add Dollar");
        dollar.setLabel("Add Dollar");
        //System.out.println("Add Dollar");
        dollar.setPreferredSize(new Dimension(200, 100));
        dollar.addActionListener(this);
        pane.add(dollar);
    }

    /**
     * A method that sets up the backButton with it's text, size, and the action listener.
     *
     *
     * @param pane the pane that the button will be added to
     */
    public void backButton(JPanel pane){
        back = new JButton();
        back.setName("Back");
        back.setLabel("Back");
        //System.out.println("Back");
        back.setPreferredSize(new Dimension(100, 100));
        back.addActionListener(this);
        pane.add(back);
    }



    /**Listens for the click of the button**/
    @Override
    public void actionPerformed(ActionEvent e) {
        /**sets a String command equal to the getActionCommand**/
        String command = ((JButton)e.getSource()).getActionCommand();

        /**sets an Array of Strings equal to an array of Strings at position 0**/
        String[] args = new String[0];

        /**If command equals Add Quarter then we add a quarter (.25) to the total**/
        if(command.equals("Add Quarter")){
            total += .25;
            text.setText("$ " + total);
        }
        /**If command equals Add Dollar then we add a dollar (1.00) to the total**/
        else if(command.equals("Add Dollar")){
            total += 1.00;
            text.setText("$ " + total);
        }
        /**If command equals Back then we return to the previous screen**/
        else if(command.equals("Back")){
          //  System.out.println("Back");
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    /**
     * Runs the the program for this screen
     * @param args
     */
    public static void main(String[] args){
        Payment pay = new Payment();
    }
}
