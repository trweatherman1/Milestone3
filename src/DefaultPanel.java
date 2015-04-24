import javax.swing.*;
import java.awt.*;

/**
 * Created by Austin on 4/23/2015.
 */
public class DefaultPanel extends JPanel {

    public DefaultPanel() {
        setVisible(true);
        setLayout(new BorderLayout());
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = Color.CYAN;
        Color color2 = Color.GREEN;
        int w = getWidth();
        int h = getHeight();
        GradientPaint gradient = new GradientPaint(0, 0, color1, w, h, color2, true);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, w, h);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DefaultPanel dp = new DefaultPanel();
        frame.add(dp);
        frame.setVisible(true);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

}
