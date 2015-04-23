import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Austin on 4/18/2015.
 */
public class MainScreen extends DefaultScreen implements ActionListener{

    public MainScreen(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent event){

    }

    public static void main(String[] args){
        MainScreen mainscreen = new MainScreen();
        mainscreen.go();
    }
    public void go() {
        //super.go();
        DefaultScreen defs = new DefaultScreen();
        JButton button = new JButton("Touch Anywhere To Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] args = new String[0];
                HomeScreen.main(args);
                setVisible(false);
                dispose();
            }
        });
        defs.add(button, BorderLayout.CENTER);
        //button.setBackground(Color.BLUE);
        Font font = new Font("Serif", Font.PLAIN, 76);
        button.setFont(font);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
    }

}
