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
}