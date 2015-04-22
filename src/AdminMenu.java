import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/20/2015.
 */
public class AdminMenu extends JFrame implements ActionListener{
    JPanel pane = new JPanel();
    JPanel center = new JPanel();
    JButton setPrice, usageStats, updateLibrary, other;

    public AdminMenu(){
        pane.setLayout(new BorderLayout());
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        pane.add(center, BorderLayout.CENTER);

        center.add(Box.createGlue());
        this.setPriceButton(center);
        center.add(Box.createGlue());
        this.usageStatsButton(center);
        center.add(Box.createGlue());
        this.updateLibraryButton(center);
        center.add(Box.createGlue());
        this.otherButton(center);
        center.add(Box.createGlue());

        setPrice.setActionCommand("Set Price");
        usageStats.setActionCommand("Usage Statistics");
        updateLibrary.setActionCommand("Update Library");
        other.setActionCommand("Other Features");



        this.setContentPane(pane);
        this.setPreferredSize(new Dimension(800,600));//Size(1000, 1000);
        this.setTitle("Admin Menu");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();



    }

    public void setPriceButton(JPanel pane){
        setPrice = new JButton();
        setPrice.setName("Set Price");
        setPrice.setLabel("Set Price");
        System.out.println("Set Price");
        setPrice.setPreferredSize(new Dimension(100, 100));
        setPrice.addActionListener(this);
        pane.add(setPrice);
    }

    public void usageStatsButton(JPanel pane){
        usageStats = new JButton();
        usageStats.setName("Usage Statistics");
        usageStats.setLabel("Usage Statistics");
        System.out.println("Usage Statistics");
        usageStats.setPreferredSize(new Dimension(100, 100));
        usageStats.addActionListener(this);
        pane.add(usageStats);
    }

    public void updateLibraryButton(JPanel pane){
        updateLibrary = new JButton();
        updateLibrary.setName("Update Library");
        updateLibrary.setLabel("Update Library");
        System.out.println("Update Library");
        updateLibrary.setPreferredSize(new Dimension(100, 100));
        updateLibrary.addActionListener(this);
        pane.add(updateLibrary);
    }

    public void otherButton(JPanel pane){
        other = new JButton();
        other.setName("Other Features");
        other.setLabel("Other Features");
        System.out.println("Other Features");
        other.setPreferredSize(new Dimension(100, 100));
        other.addActionListener(this);
        pane.add(other);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton)e.getSource()).getActionCommand();
        if(command.equals("Set Price")){
            System.out.println("Set Price");
        }
        else if(command.equals("Usage Statistics")){
            System.out.println("Usage Stats");
        }
        else if(command.equals("Update Library")){
            System.out.println("Update Library");
        }
        else if(command.equals("Other Features")){
            System.out.println("Other Features");
        }
    }

    public static void main(String[] args){
        AdminMenu admin = new AdminMenu();
    }
}
