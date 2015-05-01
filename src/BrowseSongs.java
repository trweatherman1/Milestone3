import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Trent Weatherman
 * @author Nicholas Widener
 * @author Austin Richburg
 * @author Jameson Burchette
 *
 * @version April 2015
 *
 * Creates Browse song screen
 * extends the Default screen components
 * and implements the ActionListener interface
 * to handle button clicks
 */
public class BrowseSongs extends JFrame implements ActionListener, InputDialogView.InputDialogListener {

    /**back button**/
    JButton back;

    /**scroll area**/
    JScrollPane scrollArea;

    /**panel for the list of songs**/
    JPanel directoryListing;

    /**panel for the bottom of the screen**/
    JPanel southPanel;

    /**Database controller**/
    Controller recordController;

    //==================================================================================================================
    /**
     * A constructor for BrowseSongs screen.
     */
    //==================================================================================================================
    public  BrowseSongs(){
        super();
        //new instance of the database controller
        recordController = Controller.getInstance();

        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("Browse Songs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set layout for the screen
        this.setLayout(new BorderLayout());

        //center panel
        this.addCenterPanel();

        //south panel
        this.addSouthPanel();

        //north panel
        this.addNorthPanel();


        this.setVisible(true);


        redraw(true);
    }


    /**
     * Adds the center panel that contains the list of songs
     */
    public void addCenterPanel(){
        //new scroll area
        scrollArea = new JScrollPane();
        //set size
        scrollArea.setPreferredSize(new Dimension(WIDTH, HEIGHT - 40));
        //set color
        scrollArea.setBackground(Color.BLUE);

        //panel for list
        directoryListing = new JPanel();
        //set the layout
        directoryListing.setLayout(new BoxLayout(directoryListing, BoxLayout.Y_AXIS));
        //scroll area with the songs list
        scrollArea = new JScrollPane(directoryListing);
        scrollArea.setPreferredSize(new Dimension(WIDTH, HEIGHT - 40));
        //add to main borderlayout
        this.add(scrollArea, BorderLayout.CENTER);

    }


    /**
     * Redraw the list of songs
     * @boolean loadAll When true the list is reloaded
     */


    public void redraw(boolean loadAll){
        //clear
        directoryListing.removeAll();
        if(loadAll)
            recordController.loadAll();

        for(int x = 0; x < recordController.records.size();  x++){
            //new list of songs
            SongList d = new SongList(recordController.records.get(x));
            directoryListing.add(d);
        }
        directoryListing.revalidate();
        this.repaint();
    }

    /**
     * Adds the components to the top of the screen
     */
    public void addNorthPanel(){
        JLabel songTitle = new JLabel("Song");
        JLabel artistName = new JLabel("Artist");
        JLabel albumName = new JLabel("Album");
        JLabel genreStyle = new JLabel("Genre");

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.X_AXIS));
        northPanel.add(Box.createGlue());
        northPanel.add(songTitle);
        northPanel.add(Box.createGlue());
        northPanel.add(artistName);
        northPanel.add(Box.createGlue());
        northPanel.add(albumName);
        northPanel.add(Box.createGlue());
        northPanel.add(genreStyle);
        northPanel.add(Box.createGlue());
        this.add(northPanel, BorderLayout.NORTH);

    }


    //==================================================================================================================
    /**
     * Adds the panel at the bottom containing the add and delete buttons.
     */
    //==================================================================================================================
    public void addSouthPanel(){
        //Add south panel
        back = new JButton("Back");
        //deleteSong = new JButton("Delete");
        //update = new JButton("Update");

        back.addActionListener(this);
        //deleteSong.addActionListener(this);
        //update.addActionListener(this);

        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel,BoxLayout.X_AXIS));
        southPanel.add(Box.createGlue());
        southPanel.add(back);
        southPanel.add(Box.createGlue());
        //southPanel.add(update);
        //southPanel.add(Box.createGlue());
        //southPanel.add(deleteSong);
        //southPanel.add(Box.createGlue());
        this.add(southPanel,BorderLayout.SOUTH);

        Box.createHorizontalGlue();
        Box.createVerticalGlue();
        Box.createHorizontalBox();
        Box.createVerticalBox();

    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Starts the new record dialog.
     */
    //==================================================================================================================
    public void openDialog(){
        InputDialogView dialog = new InputDialogView();
        dialog.addListener(this);
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Deletes the selected records
     */
    //==================================================================================================================
    public void delRecord(){
        for (int i =0 ; i < directoryListing.getComponentCount(); i++)
        {
            SongList d =  (SongList) directoryListing.getComponent(i);

            if(d.isChecked()){
                this.recordController.removeRecord( d.getRecord() );
            }
        }

        this.redraw(true);
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * update the selected rows if they have been written in.
     */
    //==================================================================================================================
    public void updateSelected(){

        for (int i =0 ; i < directoryListing.getComponentCount(); i++)
        {
            SongList d =  (SongList) directoryListing.getComponent(i);

            if(d.isChecked()){
                this.recordController.updateRecord(d.getRecord());
            }
        }
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Search for data and replace it in the grid of results
     * @param terms
     */
    //==================================================================================================================
    public void search(String terms){
        recordController.selectNameAndNumber("artist LIKE '" + terms + "%'",true );

        recordController.selectNameAndNumber("song LIKE '" + terms + "%'",false );

        this.redraw(false);
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Called when the dialog has oked an input.
     * @param r The telRecord to add
     */
    //==================================================================================================================
    public void dialogAddRecord(SongRecordModel r) {
        this.recordController.addRecord(r);

        this.redraw(true);
    }//=================================================================================================================


    //==================================================================================================================
    /**
     *  Called when one of the buttons is pressed.
     * @param e Contains the object the caused the event.
     */
    //==================================================================================================================
    public void actionPerformed ( ActionEvent e ){
        Object command = e.getSource();
        String[] args = new String[0];

        if(command == back){
            System.out.println("Back");
            //openDialog();
            HomeScreen.main(args);
            this.setVisible(false);
            dispose();
        }
    }//end action performed=============================================================================================




    //==================================================================================================================
    /**
     * A main method to run the program.
     * @param args Data that can be passed in from the outside.
     */
    //==================================================================================================================
    public static void main(String[] args){
        BrowseSongs browse = new BrowseSongs();
    }//=================================================================================================================
}//#####################################################################################################################
