import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//######################################################################################################################
/**
 * Created by Andrew on 4/4/14.
 * Defines an input dialog for a new directory entry.
 *
 *///###################################################################################################################
public class InputDialogView extends JDialog implements ActionListener {


    private static final long serialVersionUID = 1L;

    JTextField jtf_song, jtf_artist, jtf_album,jtf_genre;
    JLabel jl_song, jl_artist, jl_album, jl_genre;

    JLabel[] labels;
    JTextField[] textFields;
    String[] headings = {"Song","Artist", "Album", "Genre"};


    JButton cmd_ok, cmd_cancel;
    JPanel inputPanel;
    final int CHARACTER_WIDTH = 12;

    ArrayList<InputDialogListener> idl;

    //==================================================================================================================
    /**
     * Creates an input dialog for a new directory entry.
     */
    //==================================================================================================================
    public InputDialogView(){


        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        labels = new JLabel[headings.length];
        textFields = new JTextField[headings.length];
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0;i < headings.length;i++){

            labels[i] = new JLabel(headings[i]);
            textFields[i] = new JTextField(CHARACTER_WIDTH);

            //Constraints for JLabel
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.weightx = 0.2;
            gbc.anchor = GridBagConstraints.LINE_START;
            inputPanel.add(labels[i],gbc);


            //Constraints for JTextField
            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.weightx = 0.8;
            gbc.anchor = GridBagConstraints.LINE_END;

            inputPanel.add(textFields[i],gbc);
        }


        //Date date  = new Date( System.currentTimeMillis());
        //textFields[textFields.length-1].setText(date.toString());


        addButtonPanel();
        this.setContentPane(inputPanel);
        this.setSize(400,200);
        this.setVisible(true);


    }//=================================================================================================================


    //==================================================================================================================
    /**
     * Adds the panel containing the two buttons OK and Cancel.
     */
    //==================================================================================================================
    private void addButtonPanel(){
        //Add south panel
        cmd_ok = new JButton("Add");
        cmd_cancel = new JButton("Delete");

        cmd_ok.addActionListener(this);
        cmd_cancel.addActionListener(this);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel,BoxLayout.X_AXIS));
        southPanel.add(Box.createGlue());
        southPanel.add(cmd_ok);
        southPanel.add(Box.createGlue());
        southPanel.add(cmd_cancel);
        southPanel.add(Box.createGlue());

        //Constraints for panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = headings.length;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridwidth = 50;
        inputPanel.add(southPanel,gbc);
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * An interface method of the Action Listener. It is fired when the buttons are pressed.
     * @param e The ActionEvent e contains the component that caused the action event.
     */
    //==================================================================================================================
    public void actionPerformed ( ActionEvent e ){
        Object cmp = e.getSource();

        if(cmp == cmd_ok){
            this.setVisible(false);
            this.fireEvent(true);
        }
        else if (cmp == cmd_cancel){
            this.setVisible(false);
            this.fireEvent(false);
        }
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Called to notify listeners that an event has occoured.
     * @param ok True if signifying an ok state, false if not.
     */
    //==================================================================================================================
    private void fireEvent(boolean ok){

        for(int x = 0; x < textFields.length;x++)
            System.out.println(x + " : " + textFields[x].getText());


        SongRecordModel t = new SongRecordModel();
        t.setSong(textFields[0].getText());
        t.setArtist(textFields[1].getText());
        t.setAlbum(textFields[2].getText());
        t.setGenre( textFields[3].getText() );//Convert the field value to an int


        for (InputDialogListener l : idl)
            l.dialogAddRecord(t);
    }//=================================================================================================================


    //==================================================================================================================
    /**
     * A class implementing the InputDialogListener interface  registers with this to be a listener.
     * @param l The class implementing the interface to be registered.
     */
    //==================================================================================================================
    public void addListener(InputDialogListener l)
    {
        if(idl== null){
            idl = new ArrayList<InputDialogListener>();
        }
        idl.add(l);
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Defines an interface for listening for when the buttons are pressed.
     */
    //==================================================================================================================
    public interface InputDialogListener{
        public void dialogAddRecord(SongRecordModel rec);
    }//=================================================================================================================

}//#####################################################################################################################
