import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Trent on 4/20/2015.
 */
public class AdminLogin extends DefaultScreen implements ActionListener {

    JPanel pane;
    JButton submit;
    JButton back;
    JTextField user, password;

    public AdminLogin(){

        super();
        this.setPreferredSize(new Dimension(900, 600));
        this.setTitle("Admin Login");
        this.setVisible(true);

        pane = new JPanel();
        defp.add(pane, BorderLayout.CENTER);
        pane.setOpaque(false);
        pane.setLayout(new GridBagLayout());
        submit = null;
        user = null;
        password = null;
        back = null;
        GridBagConstraints con = new GridBagConstraints();
        setupButtons(con, pane, submit, user, password, back);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

    }

    private void setupButtons(GridBagConstraints con, JPanel pane, JButton submit, JTextField user, JTextField password,
                               JButton back) {



        JLabel userName = new JLabel("User Name: ");
        con.fill = GridBagConstraints.HORIZONTAL;
        con.weightx = 0.25;
        con.gridx = 0;
        con.gridy = 0;
        pane.add(userName, con);

        user = new JTextField();
        con.fill = GridBagConstraints.HORIZONTAL;
        con.weightx = 0.25;
        con.gridx = 0;
        con.gridy = 1;
        pane.add(user, con);


        JLabel userPassword = new JLabel("Password: ");
        con.fill = GridBagConstraints.HORIZONTAL;
        con.weightx = 0.25;
        con.gridx = 0;
        con.gridy = 2;
        pane.add(userPassword, con);


        password = new JTextField();
        con.fill = GridBagConstraints.HORIZONTAL;
        con.weightx = 0.25;
        con.gridx = 0;
        con.gridy = 3;
        pane.add(password, con);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.weightx = .25;
        con.gridx = 0;
        con.gridy = 4;
        pane.add(submit, con);

        back = new JButton("Back");
        back.setActionCommand("Back");
        back.addActionListener(this);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.weightx = .25;
        con.gridx = 1;
        con.gridy = 4;
        pane.add(back, con);


        con.gridwidth = 6;
        con.gridheight= 6;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object command = ((JButton)e.getSource()).getActionCommand();
        String[] args = new String[0];
        if(command.equals("Back")){
            HomeScreen.main(args);
            pane.setVisible(false);
            this.dispose();
        }
        if(command.equals("Submit")){
            if(user.getText().equals("admin") && password.getText().equals("admin")){
                AdminMenu.main(args);
                pane.setVisible(false);
                this.dispose();
            }
        }
    }



    public static void main(String[] args){
        AdminLogin admin = new AdminLogin();
    }


}
