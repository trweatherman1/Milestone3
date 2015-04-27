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
        mainscreen.setVisible(true);
    }
    public void go() {
        ImgPanel img = new ImgPanel();
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String[] args = new String[0];
                HomeScreen.main(args);
            }
        });
        button.setPreferredSize(new Dimension(900, 600));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        img.add(button);
        add(img);
        button.setFocusPainted(false);
    }

}
