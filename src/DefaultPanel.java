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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = Color.CYAN;
        Color color2 = Color.GREEN;
        int w = getWidth();
        int h = getHeight();
        GradientPaint gradient = new GradientPaint(0, 0, color1, w, h, color2, true);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, w, h);
    }

    private void display(){
        JFrame frame = new JFrame();
        frame.add(this);
        frame.setVisible(true);
        frame.setSize(900, 600);
        Dimension dim = new Dimension(900, 600);
        frame.setPreferredSize(dim);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DefaultPanel().display();
            }
        });
    }

}
