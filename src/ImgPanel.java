import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Jameson on 4/24/2015.
 */
public class ImgPanel extends JPanel {
    private BufferedImage image;

    public ImgPanel() {
        try {
            image = ImageIO.read(this.getClass().getResource("Jukebox.png"));
        } catch (IOException e) {}
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new ImgPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setPreferredSize(new Dimension(900, 600));
        //frame.setResizable(false);
        frame.setVisible(true);
    }
}