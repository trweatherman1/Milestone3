import javax.swing.*;
import java.awt.*;

/**
 * Created by Austin on 4/19/2015.
 */
public class DefaultScreen extends JFrame{

    public DefaultPanel defp;

    public DefaultScreen(){
        this.setSize(900, 600);
        Dimension dimension = new Dimension(900, 600);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setVisible(true);
        this.go();
    }

    public static void main(String[] args){
        DefaultScreen def = new DefaultScreen();
        def.go();
    }

    public void go(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("JukeMEISTER");
        defp = new DefaultPanel();
        this.add(defp);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Courier", Font.BOLD, 36));
        defp.add(label, BorderLayout.NORTH);
        defp.setVisible(true);
        //defp.setBackground(Color.BLUE);
        this.pack();
    }

}
