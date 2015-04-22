import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Keyboard extends JPanel implements MouseListener {

    String first[] = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "BackSpace"};
    String second[] = {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"};
    String third[] = {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "Enter"};
    String fourth[] = {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?"};
    String fifth[] = {"     "};

    JButton firstRow[];
    JButton secondRow[];
    JButton thirdRow[];
    JButton fourthRow[];
    JButton fifthRow[];

    public Keyboard() {

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


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}