import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * Created by Trent Weatherman on 4/15/14.
 * @author Trent Weatherman
 * @author Jameson Burchette
 * @author Austin Richburg
 * @author Nick Widener
 *
 *
 * A directory list item consists of fields for song, artist, album, and genre.
 *
 */
public class SongList extends JPanel implements  KeyListener, ItemListener, ActionListener {
    JCheckBox check;

    ArrayList<JTextField> items;/**A list of the row items in this object**/

    SongRecordModel record;

    final int CHARACTER_WIDTH = 100;/**Max album of chars for most input fields**/

    final int APP_WIDTH = 800;/**The application width**/

    final int FIELD_COUNT = 6;/**The album of fields in this GUI item**/

    private boolean selectionState = false;/**The selection state of this row.**/


    /**
     * A no argument constructor
     */
    public SongList(){
        this("","","","");
    }
    /**
     * Creates a list item by receiving a TelRecord.
     * @param r The record to visualize.
     */


    public SongList(SongRecordModel r){
        this(r.getSong(),r.getArtist(),r.getAlbum(), r.getGenre());
        this.record = r;
    }
    /**
     * Creates a listing by specifying all fields of a TelRecord.
     * @param song
     * @param artist
     * @param album
     * @param genre
     */
    private SongList(String song, String artist, String album, String genre){



        //Create GUI elements
        items = new ArrayList<JTextField>();
        check = new JCheckBox();


        //Ad the checkbox.
        this.add(Box.createGlue());
        this.add(check);

        //Use a loop to create and add the textInput fields.
        for (int i = 1; i < FIELD_COUNT; i++){
            int size= CHARACTER_WIDTH;

            //If fields is 1 t then size is 4
            if (i == 1)
                size = 4;


            JTextField jtf = new JTextField(size);
            jtf.addKeyListener(this);
            items.add(jtf);
            this.add(Box.createGlue());
            this.add(jtf);
        }//end for

        this.add(Box.createGlue());

        //Set the text of the input fields
        items.get(1).setText(song);
        items.get(2).setText(artist);
        items.get(3).setText(album);
        items.get(4).setText(genre);


        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.setMaximumSize(new Dimension(APP_WIDTH,50));
        this.setMinimumSize((new Dimension(APP_WIDTH,50)));
        this.setPreferredSize(new Dimension(APP_WIDTH,50));


        items.get(0).setBackground(Color.WHITE);
        check.setBackground(Color.white);
        check.addItemListener(this);
        check.addActionListener(this);

    }

    /**
     * Toggle the selection state of the DirectoryListItem.
     */
    public void toggleCheck(){

        setChecked(!selectionState);
    }

    /**
     * Set the item to be checked and change the background color of all items.
     * @param checked for if checked
     */
    //==================================================================================================================
    public void setChecked(boolean checked){

        selectionState = checked;
        this.check.setSelected(checked);

        Color color = Color.white;

        if (checked)
            color = Color.yellow;


        for (int i = 0; i < items.size(); i++){
            items.get(i).setBackground(color);
        }

        this.check.setBackground(color);

        setEditable(false);
    }


    /**
     * Sets whether the text fields are editable or not.
     * @param editable true or false.
     */
    public void setEditable(boolean editable){
        for (int i = 0; i < items.size(); i++)
            items.get(i).setEditable(editable);

        //check.setEnabled(editable);

        items.get(0).setEditable(false);//never editable.
    }

    /**
     * Gets the check state of this object from the check box.
     * @return  The checked state.
     */
    public boolean isChecked(){
        return this.check.isSelected();
    }


    /**
     * Update the songRecord referred to by this field.
     * @return songRecord
     */
    private SongRecordModel toRecord(){

        record.setSong(items.get(1).getText());
        record.setArtist(items.get(2).getText());
        record.setAlbum(items.get(3).getText());
        record.setGenre(items.get(4).getText());

        return record;
    }

    /**
     *  Listens for when the check box is selected/unselected
     * @param e The actionEvent containing the component that caused the event.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {


    }


    /**
     * Get the record for the song
     * @return songRecord
     */
    public SongRecordModel getRecord() {
        return record;
    }


    Controller cnt;

    /**
     * Handles action for key typed
     * @param e the event
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        cnt = Controller.getInstance();
    }

    /**
     * Handles action for key pressd
     * @param e the event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    /**
     * Action for key released
     * @param e the event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

        cnt.updateRecord(toRecord());

    }


    /**
     * Handles action performed
     * @param e the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == check) {

            AbstractButton ab = (AbstractButton) e.getSource();
            boolean selected = ab.getModel().isSelected();
            this.setChecked(selected);
        }

    }
}
