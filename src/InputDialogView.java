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

    /**JTextFields for each field in tge directory **/
    JTextField jtf_song, jtf_artist, jtf_album,jtf_genre;

    /**JLabels for each field in tge directory **/
    JLabel jl_song, jl_artist, jl_album, jl_genre;

    /**An array of JLabels**/
    JLabel[] labels;

    /**An array of JTextFields**/
    JTextField[] textFields;

    /**An array of Strings**/
    String[] titles = {"Song","Artist", "Album", "Genre"};

    /**JButtons for adding songs and deleting songs**/
    JButton addSong, deleteSong;
    
    /**The main JPanel that objects will be added to**/
    JPanel pane;
    
    /**The width of characters that will be a final**/
    final int CHARACTER_WIDTH = 25;

    ArrayList<InputDialogListener> items;

   
    /**
     * Creates an input dialog for a new directory entry.
     */
   
    public InputDialogView(){

        /**set up the main JPanel**/
        pane = new JPanel();
        /**set the layout of pane to be a GridBagLayout**/
        pane.setLayout(new GridBagLayout());

        /**set the border to be 10 for each field**/
        pane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        /**set the labels to be the length of titles**/
        labels = new JLabel[titles.length];

        /**set the textFields to be the length of titles**/
        textFields = new JTextField[titles.length];

        //set up GridBagConstraints
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0;i < titles.length;i++){

            labels[i] = new JLabel(titles[i]);
            textFields[i] = new JTextField(CHARACTER_WIDTH);

            //Constraints for JLabel
            //the position of the JLabel on the X-axis
            con.gridx = 0;
            //the position of the JLabel on the Y-axis
            con.gridy = i;
            //The height of the JLabel
            con.gridheight = 1;
            //The width of the JLabel
            con.gridwidth = 1;
            //The weight of the JLabel
            con.weightx = 0.2;
            //anchoring the JLabel
            con.anchor = GridBagConstraints.LINE_START;
            //adding the JLabel to the pane
            pane.add(labels[i],con);


            //Constraints for JTextField
            //the position of the JTextField on the X-axis
            con.gridx = 1;
            //the position of the JTextField on the Y-axis
            con.gridy = i;
            //The height of the JTextField
            con.gridheight = 1;
            //The width of the JTextField
            con.gridwidth = 1;
            //The weight of the JTextField
            con.weightx = 0.8;
            con.anchor = GridBagConstraints.LINE_END;

            pane.add(textFields[i],con);
        }
        

        buttonPanel();
        this.setContentPane(pane);
        this.setSize(400,200);
        this.setVisible(true);

    }


    
    /**
     * Adds the panel containing two JButtons and a JPanel.
     */
    
    private void buttonPanel(){
        //set the title of the addSong button to Add
        addSong = new JButton("Add");
        //set the title of the deleteSong button to Delete
        deleteSong = new JButton("Delete");

        //set the addActionListener for addSong button
        addSong.addActionListener(this);
        //set the addActionListener for deleteSong button
        deleteSong.addActionListener(this);

        //set up a JPanel called south to be in the south border layout
        JPanel south = new JPanel();
        //set the layout of south to be a BoxLayout along the X-axis
        south.setLayout(new BoxLayout(south,BoxLayout.X_AXIS));
        //add glue to the first layer of south pane
        south.add(Box.createGlue());
        //add the addSong button to the south panel
        south.add(addSong);
        //add glue to the second layer of south pane
        south.add(Box.createGlue());
        //add the deleteSong button to the south panel
        south.add(deleteSong);
        //add glue to the third layer of south pane
        south.add(Box.createGlue());

        //set up the GridBag Constraints for panel
        GridBagConstraints con = new GridBagConstraints();
        //the position of the south JPanel on the X-axis
        con.gridx = 0;
        //the position of the south JPanel on the Y-axis
        con.gridy = titles.length;
        //The height of the south JPanel
        con.gridheight = 1;
        //The width of the south JPanel
        con.gridwidth = 1;
        //The weight of the JPanel
        con.gridwidth = 50;
        //adding the south pane to the pane
        pane.add(south,con);
    }

   
    /**
     * A method that listens for the action commands of buttons
     * @param e The ActionEvent e contains the component that caused the action event.
     */
    
    public void actionPerformed ( ActionEvent e ){
        Object command = e.getSource();

        //if command is addSong then fire the event
        if(command == addSong){
            this.setVisible(false);
            this.fireEvent(true);
        }
        //if command is deleteSong then don't fire the event
        else if (command == deleteSong){
            this.setVisible(false);
            this.fireEvent(false);
        }
    }
    
    /**
     * Called to notify listeners that an event has occured.
     * @param alrightState True if signifying an ok state, false if not.
     */
    
    private void fireEvent(boolean alrightState){

        for(int x = 0; x < textFields.length;x++)
            System.out.println(x + " : " + textFields[x].getText());


        SongRecordModel record = new SongRecordModel();
        record.setSong(textFields[0].getText());
        record.setArtist(textFields[1].getText());
        record.setAlbum(textFields[2].getText());
        record.setGenre( textFields[3].getText() );


        for (InputDialogListener l : items)
            l.dialogAddRecord(record);
    }
    
    /**
     * A method that implements the InputDialogListener interface.
     * @param listener The class implementing the interface to be registered.
     */
    
    public void addListener(InputDialogListener listener)
    {
        if(items== null){
            items = new ArrayList<InputDialogListener>();
        }
        items.add(listener);
    }
    
    /**
     * Defines an interface when the buttons are pressed
     */
    
    public interface InputDialogListener{
        public void dialogAddRecord(SongRecordModel rec);
    }

}
