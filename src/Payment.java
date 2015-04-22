import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/18/2015.
 */
public class Payment extends JFrame implements ActionListener{
    JPanel pane;
    JPanel center;
    JPanel south;
    //JPanel north;
    JTextField text;
    JButton quarter;
    JButton dollar;
    JButton back;
    double total;


    public Payment(){
        pane = new JPanel();
        center = new JPanel();
        south = new JPanel();
        //north = new JPanel();
        text = new JTextField();
        text.setPreferredSize(new Dimension(150, 30));
        pane.setLayout(new BorderLayout());
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
       // north.setLayout(new BoxLayout(north, BoxLayout.X_AXIS));

        pane.add(center, BorderLayout.CENTER);
        pane.add(south, BorderLayout.SOUTH);
        //pane.add(north, BorderLayout.NORTH);

        //text = total;




        text.setText("$ " + total);
        center.add(text);
        south.add(Box.createGlue());
        this.quarterButton(south);
        south.add(Box.createGlue());
        this.dollarButton(south);
        south.add(Box.createGlue());
        this.backButton(south);
        south.add(Box.createGlue());


        total = 0.00;
        //text = total;

        this.setContentPane(pane);
        this.setPreferredSize(new Dimension(800, 600));
        this.setTitle("Payment Screen");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    public void quarterButton(JPanel pane){
        quarter = new JButton();
        quarter.setName("Add Quarter");
        quarter.setLabel("Add Quarter");
        System.out.println("Add Quarter");
        quarter.setPreferredSize(new Dimension(100, 100));
        quarter.addActionListener(this);
        pane.add(quarter);

    }

    public void dollarButton(JPanel pane){
        dollar = new JButton();
        dollar.setName("Add Dollar");
        dollar.setLabel("Add Dollar");
        System.out.println("Add Dollar");
        dollar.setPreferredSize(new Dimension(100, 100));
        dollar.addActionListener(this);
        pane.add(dollar);
    }

    public void backButton(JPanel pane){
        back = new JButton();
        back.setName("Back");
        back.setLabel("Back");
        System.out.println("Back");
        back.setPreferredSize(new Dimension(100, 100));
        back.addActionListener(this);
        pane.add(back);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton)e.getSource()).getActionCommand();
        String[] args = new String[0];
        if(command.equals("Add Quarter")){
            total += .25;
            text.setText("$ " + total);
        }
        else if(command.equals("Add Dollar")){
            total += 1.00;
            text.setText("$ " + total);
        }
        else if(command.equals("Back")){
            System.out.println("Back");
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    public static void main(String[] args){
        Payment pay = new Payment();
    }
}
