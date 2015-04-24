import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/18/2015.
 */
public class HomeScreen extends DefaultScreen implements ActionListener{

    JPanel pane;
    //JPanel south;
    JButton browse;
    JButton search;
    JButton admin;
    JButton payment;

    public HomeScreen(){
        pane = new JPanel();
        //south = new JPanel();

        //pane.setLayout(new BorderLayout());
        
        defp.setLayout(new BoxLayout(defp, BoxLayout.Y_AXIS));
        defp.add(Box.createGlue());
        this.browseSongsButton(defp);
        defp.add(Box.createGlue());
        this.searchSongsButton(defp);
        defp.add(Box.createGlue());
        this.paymentButton(defp);
        defp.add(Box.createGlue());
        this.adminButton(defp);
        defp.add(Box.createGlue());


        //south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
        //this.adminButton(south);
        //south.add(Box.createGlue());



        //pane.add(defp, BorderLayout.CENTER);
        //pane.add(south, BorderLayout.SOUTH);

        browse.setActionCommand("Browse Songs");
        search.setActionCommand("Search Songs");
        admin.setActionCommand("Admin");
        payment.setActionCommand("Payment");

        this.setContentPane(pane);
        this.setPreferredSize(new Dimension(1000, 700));//Size(1000, 1000);
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
        //System.out.println("Browse Songs");
        browse.setPreferredSize(new Dimension(100, 100));
        browse.setMaximumSize(new Dimension(200, 300));

        browse.addActionListener(this);
        pane.add(browse);
        browse.setForeground(Color.BLACK);
        browse.setBackground(Color.CYAN);
        browse.setFocusPainted(false);
    }

    public void searchSongsButton(JPanel pane){
        search = new JButton();
        search.setName("Search Songs");
        search.setLabel("Search Songs");
        //System.out.println("Search Songs");
        search.setAlignmentX(Component.CENTER_ALIGNMENT);
        search.setPreferredSize(new Dimension(100, 100));
        search.setMaximumSize(new Dimension(200, 300));

        search.addActionListener(this);
        pane.add(search);
        search.setBackground(Color.CYAN);
        search.setForeground(Color.BLACK);
    }

    public void adminButton(JPanel pane){
        admin = new JButton();
        admin.setName("Admin");
        admin.setLabel("Admin");
        //System.out.println("Admin");
        admin.setPreferredSize(new Dimension(100, 100));
        admin.setMinimumSize(new Dimension(200, 300));
        admin.addActionListener(this);
        //admin.setOpaque(true);
        //admin.setVisible(false);
        pane.add(admin);
        admin.setBackground(Color.CYAN);
        admin.setForeground(Color.BLACK);
    }

    public void paymentButton(JPanel pane){
        payment = new JButton();
        payment.setName("Payment");
        payment.setLabel("Payment");
        payment.setAlignmentX(Component.CENTER_ALIGNMENT);
        //System.out.println("Payment");
        payment.setPreferredSize(new Dimension(100, 100));
        payment.setMinimumSize(new Dimension(200, 300));
        //payment.setMaximumSize(new Dimension(200, 300));
        payment.addActionListener(this);
        //admin.setVisible(false);
        pane.add(payment);
        payment.setBackground(Color.CYAN);
        payment.setForeground(Color.BLACK);
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
            defp.setVisible(false);
            dispose();
        }
        else if(command.equals("Admin")){
            System.out.println("admin");

            AdminLogin.main(args);
            defp.setVisible(false);
            dispose();
        }
        else if(command.equals("Payment")){
            System.out.println("Payment");

            Payment.main(args);
            defp.setVisible(false);
            dispose();
        }
    }

    public static void main(String[] args){

        HomeScreen home = new HomeScreen();
    }
}
