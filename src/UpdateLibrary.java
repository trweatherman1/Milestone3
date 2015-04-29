import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jameson on 4/21/2015.
 */
public class UpdateLibrary extends DefaultScreen implements ActionListener{

        private JPanel pane;
        private JDialog dialog;
        private JTextField tf;
        private JTextField tf2;
        private JTextField tf3;
        private JTextField tf4;
        private Controller c;

    public UpdateLibrary() {
        pane = new JPanel(new BorderLayout());
        pane.setOpaque(false);
        addCenter(pane);
        addNorth(pane);
        display(pane);
        defp.add(pane);
    }

    public void addCenter(JPanel pane) {
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(Box.createGlue());
        addButton("Add Songs", new Dimension(100, 100), center);
        center.add(Box.createGlue());
        addButton("Remove Songs", new Dimension(100, 100), center);
        center.add(Box.createGlue());
        pane.add(center, BorderLayout.CENTER);
    }

    public void addNorth(JPanel pane) {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));
        north.setOpaque(false);
        addButton("Back", new Dimension(100, 100), north);
        north.add(Box.createGlue());
        north.add(new JLabel("Update Library"));
        north.add(Box.createGlue());
        pane.add(north, BorderLayout.NORTH);
    }

    public void addButton(String name, Dimension size, JPanel pane) {
        JButton button = new JButton(name);
        button.setPreferredSize(size);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(300, 300));
        pane.add(button);
    }

    public void display(JPanel pane) {
        this.setPreferredSize(new Dimension(900, 600));
        this.setTitle("Update Library");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void makeDialog(ActionEvent e){
        dialog = new JDialog();
        JPanel panel = new JPanel();
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        Font font = new Font(null, Font.ITALIC, 12);

        c = Controller.getInstance();
        c.connect();

        panel.setLayout(new BorderLayout());
        p.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());

        dialog.setSize(350, 200);
        dialog.setPreferredSize(new Dimension(350, 200));
        dialog.setResizable(false);
        dialog.setLocationRelativeTo((JButton) e.getSource());

        JLabel label = new JLabel("Song: ");
        label.setPreferredSize(new Dimension(55, 21));
        p.add(label);
        tf = new JTextField("Enter Song");
        tf.setPreferredSize(new Dimension(270, 21));
        tf.setFont(font);
        p.add(tf);
        label = new JLabel("Artist: ");
        label.setPreferredSize(new Dimension(55, 21));
        p.add(label);
        tf2 = new JTextField("Enter Artist");
        tf2.setPreferredSize(new Dimension(270, 21));
        tf2.setFont(font);
        p.add(tf2);
        label = new JLabel("Album: ");
        label.setPreferredSize(new Dimension(55, 21));
        p.add(label);
        tf3 = new JTextField("Enter Album");
        tf3.setPreferredSize(new Dimension(270, 21));
        tf3.setFont(font);
        p.add(tf3);
        label = new JLabel("Genre: ");
        label.setPreferredSize(new Dimension(55, 21));
        p.add(label);
        tf4 = new JTextField("Enter Genre");
        tf4.setPreferredSize(new Dimension(270, 21));
        tf4.setFont(font);
        p.add(tf4);
        label = new JLabel("Path: ");
        label.setPreferredSize(new Dimension(55, 21));
        p.add(label);

        JButton button2 = new JButton("Submit");
        button2.setForeground(Color.BLACK);
        button2.setFocusPainted(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.addRecord(tf.getText(), tf2.getText(), tf3.getText(), tf4.getText());
            }
        });
        p2.add(button2);
        button2 = new JButton("Back");
        button2.setForeground(Color.BLACK);
        button2.setFocusPainted(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        p2.add(button2);

        dialog.add(panel);
        panel.add(p, BorderLayout.CENTER);
        panel.add(p2, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton)e.getSource()).getActionCommand();
        String[] args = new String[0];
        if (command.equals("Add Songs")) {
            this.makeDialog(e);
        }
        else if (command.equals("Remove Songs")) {
            System.out.println("remove songs");
        }
        else if (command.equals("Back")) {
            System.out.println("back");
            AdminMenu.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    public static void main(String args[]) { new UpdateLibrary(); }
}
