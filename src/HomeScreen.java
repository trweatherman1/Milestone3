import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/18/2015.
 */
public class HomeScreen extends JFrame implements ActionListener{

    JPanel pane;
    JPanel center;
    JPanel south;
    JButton browse;
    JButton search;
    JButton admin;
    JButton payment;

    public HomeScreen(){
        pane = new JPanel();
        center = new JPanel();
        south = new JPanel();

        pane.setLayout(new BorderLayout());


        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(Box.createGlue());
        this.browseSongsButton(center);
        center.add(Box.createGlue());
        this.searchSongsButton(center);
        center.add(Box.createGlue());
        this.paymentButton(center);
        center.add(Box.createGlue());


        south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
        this.adminButton(south);
        south.add(Box.createGlue());



        pane.add(center, BorderLayout.CENTER);
        pane.add(south, BorderLayout.SOUTH);

        browse.setActionCommand("Browse Songs");
        search.setActionCommand("Search Songs");
        admin.setActionCommand("Admin");
        payment.setActionCommand("Payment");

        this.setContentPane(pane);
        this.setPreferredSize(new Dimension(800, 600));//Size(1000, 1000);
        this.setTitle("Main Menu");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void browseSongsButton(JPanel pane){
        browse = new JButton();
        browse.setName("Browse Songs");
        browse.setLabel("Browse Songs");
        browse.setAlignmentX(Component.CENTER_ALIGNMENT);
        System.out.println("Browse Songs");
        browse.setPreferredSize(new Dimension(100,100));
        browse.addActionListener(this);
        pane.add(browse);
    }

    public void searchSongsButton(JPanel pane){
        search = new JButton();
        search.setName("Search Songs");
        search.setLabel("Search Songs");
        System.out.println("Search Songs");
        search.setAlignmentX(Component.CENTER_ALIGNMENT);
        search.setPreferredSize(new Dimension(100, 100));
        search.addActionListener(this);
        pane.add(search);
    }

    public void adminButton(JPanel pane){
        admin = new JButton();
        admin.setName("Admin");
        admin.setLabel("Admin");
        System.out.println("Admin");
        admin.setPreferredSize(new Dimension(100, 100));
        admin.addActionListener(this);
        //admin.setVisible(false);
        pane.add(admin);
    }

    public void paymentButton(JPanel pane){
        payment = new JButton();
        payment.setName("Payment");
        payment.setLabel("Payment");
        payment.setAlignmentX(Component.CENTER_ALIGNMENT);
        System.out.println("Payment");
        payment.setPreferredSize(new Dimension(100, 100));
        payment.addActionListener(this);
        //admin.setVisible(false);
        pane.add(payment);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton)e.getSource()).getActionCommand();
        String[] args = new String[0];
        if(command.equals("Browse Songs")){
            System.out.println("browse");
        }
        else if(command.equals("Search Songs")){
            System.out.println("search");
            SearchScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        else if(command.equals("Admin")){
            System.out.println("admin");

            AdminLogin.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        else if(command.equals("Payment")){
            System.out.println("Payment");

            Payment.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    public static void main(String[] args){

        HomeScreen menu = new HomeScreen();
    }
}
