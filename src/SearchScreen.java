import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nicholas on 4/20/2015.
 */
public class SearchScreen extends JFrame implements ActionListener {


    JPanel pane;
    JPanel center;
    JButton search;
    JButton back;
    JTextField text1;
    JLabel title;
    Keyboard keyboard = new Keyboard();




    public SearchScreen() {
        pane = new JPanel();
        text1 = new JTextField();
        title = new JLabel();

        pane.setLayout(new BorderLayout());

        setUpCenter();

        pane.add(center, BorderLayout.CENTER);


        pane.add(keyboard, BorderLayout.SOUTH);


        this.setSize(1100, 600);
        //this.setPreferredSize(new Dimension(1400,600));
        this.setContentPane(pane);
        this.setTitle("Search Screen");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void searchSongsButton(JPanel pane){
        search = new JButton();
        search.setName("Search Songs");
        search.setLabel("Search Songs");
        //System.out.println("Browse Songs");
        search.setPreferredSize(new Dimension(400, 200));
        search.addActionListener(this);
        pane.add(search);
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

    private void setUpCenter() {
        center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        title.setText("Search Songs");
        center.add(title);
        center.add(Box.createGlue());
        text1.setPreferredSize(new Dimension(500, 300));
        center.add(text1);
        center.add(Box.createGlue());
        this.searchSongsButton(center);
        center.add(Box.createGlue());
        this.backButton(center);
        center.add(Box.createGlue());

        back.setActionCommand("Back");
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String[] args = new String[0];
        if(command.equals("Back")){
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SearchScreen ss = new SearchScreen();
    }
}
