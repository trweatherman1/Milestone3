import javax.swing.*;
import java.awt.*;

/**
 * Created by Austin on 4/19/2015.
 */
public class DefaultScreen extends JFrame{

    public JFrame frame;
    public JPanel panel;

    public DefaultScreen(){
        frame = new JFrame();
        frame.setSize(900, 600);
        Dimension dimension = new Dimension(900, 600);
        frame.setPreferredSize(dimension);
        frame.setVisible(true);
    }

    /*
    @Override
    public void paintComponents(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D)g;
        Color color1 = Color.CYAN;
        Color color2 = Color.GREEN;
        int w = frame.getWidth();
        int h = frame.getHeight();
        GradientPaint gradient = new GradientPaint(0, 0, color1, w, h, color2, true);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight());
    }
    */

    public static void main(String[] args){
        DefaultScreen def = new DefaultScreen();
        def.go();
    }

    public void go(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("JukeMEISTER");
        panel = new JPanel();
        frame.add(panel);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Courier", Font.BOLD, 36));
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.setVisible(true);
        panel.setBackground(Color.BLUE);
        frame.pack();
    }

}
