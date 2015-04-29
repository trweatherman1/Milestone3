import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/18/2015.
 */
public class HomeScreen extends DefaultScreen implements ActionListener{

    JButton browse;
    JButton search;
    JButton admin;
    JButton payment;

    public HomeScreen(){
        defp.setVisible(true);
        defp.setLayout(new FlowLayout());
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

        browse.setActionCommand("Browse Songs");
        search.setActionCommand("Search Songs");
        admin.setActionCommand("Admin");
        payment.setActionCommand("Payment");

        this.setPreferredSize(new Dimension(900, 600));//Size(1000, 1000);
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
    }

    public void adminButton(JPanel pane){
        admin = new JButton();
        admin.setName("Admin");
        admin.setLabel("Admin");
        admin.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin.setPreferredSize(new Dimension(100, 100));
        admin.setMaximumSize(new Dimension(200, 300));
        admin.addActionListener(this);
        pane.add(admin);
    }

    public void paymentButton(JPanel pane){
        payment = new JButton();
        payment.setName("Payment");
        payment.setLabel("Payment");
        payment.setAlignmentX(Component.CENTER_ALIGNMENT);
        payment.setPreferredSize(new Dimension(100, 100));
        payment.setMaximumSize(new Dimension(200, 300));
        payment.addActionListener(this);
        pane.add(payment);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton)e.getSource()).getActionCommand();
        String[] args = new String[0];
        if(command.equals("Browse Songs")){
            //System.out.println("browse");
            BrowseSongs.main(args);
            defp.setVisible(false);
            dispose();
        }
        else if(command.equals("Search Songs")){
            //System.out.println("search");
            SearchScreen.main(args);
            defp.setVisible(false);
            dispose();
        }
        else if(command.equals("Admin")){
            //System.out.println("admin");

            AdminLogin.main(args);
            defp.setVisible(false);
            dispose();
        }
        else if(command.equals("Payment")){
            //System.out.println("Payment");

            Payment.main(args);
            defp.setVisible(false);
            dispose();
        }
    }

    public static void main(String[] args){

        HomeScreen home = new HomeScreen();
    }
}
