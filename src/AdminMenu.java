import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/20/2015.
 */
public class AdminMenu extends DefaultScreen implements ActionListener{
    JPanel pane = new JPanel();
    JPanel center = new JPanel();
    JPanel west = new JPanel();
    JButton setPrice, usageStats, updateLibrary, other, logout;

    public AdminMenu(){
        super();
        pane.setOpaque(false);
        defp.add(pane);
        pane.setLayout(new BorderLayout());
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        west.setOpaque(false);
        west.setLayout(new FlowLayout());

        pane.add(center, BorderLayout.CENTER);
        pane.add(west, BorderLayout.WEST);

        center.add(Box.createGlue());
        this.setPriceButton(center);
        center.add(Box.createGlue());
        this.usageStatsButton(center);
        center.add(Box.createGlue());
        this.updateLibraryButton(center);
        center.add(Box.createGlue());
        this.otherButton(center);
        center.add(Box.createGlue());

        this.logoutButton(west);

        setPrice.setActionCommand("Set Price");
        usageStats.setActionCommand("Usage Statistics");
        updateLibrary.setActionCommand("Update Library");
        other.setActionCommand("Other Features");

        this.setPreferredSize(new Dimension(900,600));//Size(1000, 1000);
        this.setTitle("Admin Menu");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void setPriceButton(JPanel pane){
        setPrice = new JButton();
        setPrice.setName("Set Price");
        setPrice.setLabel("Set Price");
        //System.out.println("Set Price");
        setPrice.setPreferredSize(new Dimension(100, 100));
        setPrice.setMaximumSize(new Dimension(200,300));
        setPrice.setAlignmentX(CENTER_ALIGNMENT);
        setPrice.addActionListener(this);
        pane.add(setPrice);
    }

    public void usageStatsButton(JPanel pane){
        usageStats = new JButton();
        usageStats.setName("Usage Statistics");
        usageStats.setLabel("Usage Statistics");
        //System.out.println("Usage Statistics");
        usageStats.setPreferredSize(new Dimension(100, 100));
        usageStats.setMaximumSize(new Dimension(200,300));
        usageStats.setAlignmentX(CENTER_ALIGNMENT);
        usageStats.addActionListener(this);
        pane.add(usageStats);
    }

    public void updateLibraryButton(JPanel pane){
        updateLibrary = new JButton();
        updateLibrary.setName("Update Library");
        updateLibrary.setLabel("Update Library");
        //System.out.println("Update Library");
        updateLibrary.setPreferredSize(new Dimension(100, 100));
        updateLibrary.setMaximumSize(new Dimension(200,300));
        updateLibrary.addActionListener(this);
        updateLibrary.setAlignmentX(CENTER_ALIGNMENT);
        pane.add(updateLibrary);
    }

    public void otherButton(JPanel pane){
        other = new JButton();
        other.setName("Other Features");
        other.setLabel("Other Features");
        //System.out.println("Other Features");
        other.setPreferredSize(new Dimension(100, 100));
        other.setMaximumSize(new Dimension(200,300));
        other.setAlignmentX(CENTER_ALIGNMENT);
        other.addActionListener(this);
        pane.add(other);
    }

    public void logoutButton(JPanel pane){
        logout = new JButton();
        logout.setName("Logout");
        logout.setLabel("Logout");
        logout.setFocusPainted(false);
        logout.setPreferredSize(new Dimension(100, 100));
        logout.addActionListener(this);
        pane.add(logout);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton)e.getSource()).getActionCommand();
        String[] args = new String[0];
        if(command.equals("Set Price")){
            //System.out.println("Set Price");
        }
        else if(command.equals("Usage Statistics")){
            //System.out.println("Usage Stats");

        }
        else if(command.equals("Update Library")){
            //System.out.println("Update Library");
            UpdateLibrary.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        else if(command.equals("Other Features")){
            //System.out.println("Other Features");
            OtherFeatures.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        else if(command.equals("Logout")){
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    public static void main(String[] args){
        AdminMenu admin = new AdminMenu();
    }
}
