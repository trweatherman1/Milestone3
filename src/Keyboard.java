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
 * Creates the keyboard for JukeMeister
 * Extends Default screen and implements the
 * KeyListener interface so buttons can be clicked
 * Extends JPanel so it can be used anywhere
 */
public class Keyboard extends JPanel implements KeyListener {

    /**first row of keys**/
    String first[] = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "BackSpace"};

    /**second row of keys**/
    String second[] = {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"};

    /**third row of keys**/
    String third[] = {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "Enter"};

    /**fourth row of keys**/
    String fourth[] = {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?"};

    /**fifth row of keys**/
    String fifth[] = {"     "};

    /**buttons for first row**/
    JButton firstRow[];

    /**buttons for second row**/
    JButton secondRow[];

    /**buttons for third row**/
    JButton thirdRow[];

    /**buttons for fourth row**/
    JButton fourthRow[];

    /**buttons for fifth row**/
    JButton fifthRow[];

    /**
     * Create the keyboard
     */
    public Keyboard() {

        //set visible
        this.setVisible(true);
        //set size
        this.setMaximumSize(new Dimension(1400, 300));

        //call to initialize keyboard components
        initWidgets();
    }

    /**
     * Sets the layout and sets
     * the keys up for the keyboard
     */
    private void initWidgets() {
        //set the layout
        setLayout(new BorderLayout());
        //create the keyboard
        JPanel keyboard = new JPanel();
        //add to the borderlayout
        add(keyboard, BorderLayout.SOUTH);
        //set keyboard layout
        keyboard.setLayout(new GridLayout(5, 1));

        //**************************************************************************************************************
        //First Row
        firstRow = new JButton[first.length];

        JPanel panel = new JPanel(new GridLayout(1, first.length));
        for (int i = 0; i < first.length; i++) {
            JButton button = new JButton(first[i]);
            button.setPreferredSize(new Dimension(100, 50));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.toString().equals(first[0])) {
                        SearchScreen.text1.setText(first[0]);
                    }
                }
            });
            firstRow[i] = button;
            panel.add(firstRow[i]);
        }
        keyboard.add(panel);


        //**************************************************************************************************************
        //Second Row
        secondRow = new JButton[second.length];
        panel = new JPanel(new GridLayout(1, second.length));
        for (int i = 0; i < second.length; i++) {
            secondRow[i] = new JButton(second[i]);
            panel.add(secondRow[i]);
        }
        keyboard.add(panel);


        //**************************************************************************************************************
        //Third Row
        thirdRow = new JButton[third.length];

        panel = new JPanel((new GridLayout(1, third.length)));
        for (int i = 0; i < third.length; i++) {
            thirdRow[i] = new JButton(third[i]);
            panel.add(thirdRow[i]);
        }
        keyboard.add(panel);


        //**************************************************************************************************************
        //Fourth Row
        fourthRow = new JButton[fourth.length];

        panel = new JPanel((new GridLayout(1, fourth.length)));
        for (int i = 0; i < fourth.length; i++) {
            fourthRow[i] = new JButton(fourth[i]);
            panel.add(fourthRow[i]);
            if (i == fourth.length - 2)
                panel.add(new JPanel());
        }
        panel.add(new JPanel());
        keyboard.add(panel);


        //**************************************************************************************************************
        //Fifth Row
        fifthRow = new JButton[fifth.length];
        panel = new JPanel(new GridLayout(1, fifth.length));

        for (int i = 0; i < fifth.length; i++) {
            fifthRow[i] = new JButton(fifth[i]);
            panel.add(fifthRow[i]);
            if (i == fifth.length - 2)
                panel.add(new JPanel());
        }
        panel.add(new JPanel());
        keyboard.add(panel);
    }

    /**
     * Handles the key typed
     * @param e the event
     */
    @Override
    public void keyTyped(KeyEvent e) {
    //empty for now
    }

    /**
     * Handles the key pressed
     * @param e the event
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Handles the key released
     * @param e the event
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}