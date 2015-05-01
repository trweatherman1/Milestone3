import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//########################################################################################################
/**
 * Created by Andrew on 4/3/14.
 */
//######################################################################################################################
public class SongDirectory extends JFrame implements ActionListener, InputDialogView.InputDialogListener {

    /**All of the buttons used in this screen**/
    JButton addSong,deleteSong, update, back;
    
    /**the scroller panel**/
    JScrollPane scrollPane;
    
    /**the listing of items in the scrollPane**/
    JPanel listing;

    /**A JPanel that will be in the south border of the frame**/
    JPanel south;

    /**a controller object for the records in the class**/
    Controller recordController;

    
    /**
     * A constructor that will build our SongDirectory
     */
    
    public  SongDirectory(){
        super();

        recordController = Controller.getInstance();

        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("Browse Songs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);

        this.setLayout(new BorderLayout());

        this.addCenter();
        this.addSouth();
        this.addNorth();


        this.setVisible(true);


        redraw(true);
    }

   
    /**
     * Adds the center JPanel that will contain the scrollPane 
     */
    
    public void addCenter(){
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT - 40));
        scrollPane.setBackground(Color.BLUE);


        listing = new JPanel();
        listing.setLayout(new BoxLayout(listing, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane(listing);
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT - 40));



        this.add(scrollPane, BorderLayout.CENTER);

    }

    
    /**
     * Redraw the table if there has been any changes to it
     * @boolean loadAll for if the table has been redrawn
     */
    
    public void redraw(boolean loadAll){

        listing.removeAll();//Clear components.
        if(loadAll)
            recordController.loadAll();

        for(int x = 0; x < recordController.records.size();  x++){
            SongList d = new SongList(recordController.records.get(x));
            listing.add(d);
        }//end x
        listing.revalidate();
        this.repaint();
    }

    /**
     * A frame that will add the north JPanel to the main panel
     */
    public void addNorth(){
        JLabel songTitle = new JLabel("Song");
        JLabel artistName = new JLabel("Artist");
        JLabel albumName = new JLabel("Album");
        JLabel genreStyle = new JLabel("Genre");

        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
        north.add(Box.createGlue());
        north.add(songTitle);
        north.add(Box.createGlue());
        north.add(artistName);
        north.add(Box.createGlue());
        north.add(albumName);
        north.add(Box.createGlue());
        north.add(genreStyle);
        north.add(Box.createGlue());
        this.add(north, BorderLayout.NORTH);

    }


    
    /**
     * Adds the panel at the bottom containing the add and delete buttons.
     */
    
    public void addSouth(){
        //Add south panel
        back = new JButton("Back");
        addSong = new JButton("Add");
        deleteSong = new JButton("Delete");
        update = new JButton("Update");

        back.addActionListener(this);
        addSong.addActionListener(this);
        deleteSong.addActionListener(this);
        update.addActionListener(this);

        south = new JPanel();
        south.setLayout(new BoxLayout(south,BoxLayout.X_AXIS));
        south.add(Box.createGlue());
        south.add(back);
        south.add(Box.createGlue());
        south.add(addSong);
        south.add(Box.createGlue());
        south.add(update);
        south.add(Box.createGlue());
        south.add(deleteSong);
        south.add(Box.createGlue());
        this.add(south,BorderLayout.SOUTH);

        Box.createHorizontalGlue();
        Box.createVerticalGlue();
        Box.createHorizontalBox();
        Box.createVerticalBox();

    }//=================================================================================================================

    
    /**
     * Starts the new record dialog.
     */
    
    public void openDialog(){
        InputDialogView dialog = new InputDialogView();
        dialog.addListener(this);
    }

    
    /**
     * Deletes the selected records
     */
    
    public void delRecord(){
        for (int i =0 ; i < listing.getComponentCount(); i++)
        {
            SongList d =  (SongList) listing.getComponent(i);

            if(d.isChecked()){
                this.recordController.removeRecord( d.getRecord() );
            }
        }

        this.redraw(true);
    }

    
    /**
     * update the rows that any changes have been made to.
     */
   
    public void updateSelected(){

        for (int i =0 ; i < listing.getComponentCount(); i++)
        {
            SongList d =  (SongList) listing.getComponent(i);

            if(d.isChecked()){
                this.recordController.updateRecord(d.getRecord());
            }
        }
    }
    
        
    /**
     * Called when the the input has been verified
     * @param record The record to add
     */
   
    public void dialogAddRecord(SongRecordModel record) {
        this.recordController.addRecord(record);

        this.redraw(true);
    }


    
    /**
     *  A listener for one the action commands of the buttons 
     * @param e Contains the object the caused the event.
     */
    
    public void actionPerformed ( ActionEvent e ){
        Object command = e.getSource();
        String[] args = new String[0];

        if(command == addSong){
            System.out.println("Add");
            openDialog();
        }

        else if(command == update){
            System.out.println("Update Selected");
            updateSelected();
        }

        else if (command == deleteSong){
            System.out.println("Del");
            delRecord();
        }

        else if(command == back){
            AdminMenu.main(args);
            this.setVisible(false);
            dispose();
        }
    }


    /**
     * A method to run the program.
     * @param args 
     */
    
    public static void main(String[] args){
        SongDirectory songDirectory = new SongDirectory();
    }
}
