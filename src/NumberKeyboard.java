import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
 */
public class NumberKeyboard extends JPanel implements KeyListener {
    String first[] = {"1", "2", "3"};
    String second[]= {"4", "5", "6"};
    String third[] = {"7", "8", "9"};
    String fourth[] = {".","0", "CE"};


    JButton firstRow[];
    JButton secondRow[];
    JButton thirdRow[];
    JButton fourthRow[];

    public NumberKeyboard(){
        this.setVisible(true);
        this.setMaximumSize(new Dimension(1400, 300));


        initWidgets();
    }

    private void initWidgets() {
        setLayout(new BorderLayout());
        JPanel keyboard = new JPanel();

        add(keyboard, BorderLayout.SOUTH);

        keyboard.setLayout(new GridLayout(5, 1));

        //**************************************************************************************************************
        //First Row
        firstRow = new JButton[first.length];

        JPanel panel = new JPanel(new GridLayout(1, first.length));
        for (int i = 0; i < first.length; i++) {
            JButton button = new JButton(first[i]);
            button.setPreferredSize(new Dimension(100, 50));
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

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
