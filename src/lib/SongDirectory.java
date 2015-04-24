package lib;

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

    JButton cmd_add;
    JButton cmd_del;
    JButton cmd_update;
    JButton cmd_search;
    JTextField jtf_search;

    JScrollPane scrollArea;
    JPanel directoryListing;

    JPanel southPanel;

    Controller recordController;

    //==================================================================================================================
    /**
     * A constructor for our TelephoneDirectory object.
     */
    //==================================================================================================================
    public  SongDirectory(){
        super();

        recordController = Controller.getInstance();


        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("Browse Songs");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);

        this.setLayout(new BorderLayout());

        this.addCenterPanel();
        this.addSouthPanel();
        this.addNorthPanel();

        this.setVisible(true);


        redraw(true);
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Add's the center panel containing the list of telephone numbers;
     */
    //==================================================================================================================
    public void addCenterPanel(){
        scrollArea = new JScrollPane();
        scrollArea.setPreferredSize(new Dimension(WIDTH, HEIGHT - 40));
        scrollArea.setBackground(Color.BLUE);


        directoryListing = new JPanel();
        directoryListing.setLayout(new BoxLayout(directoryListing, BoxLayout.Y_AXIS));

        scrollArea = new JScrollPane(directoryListing);
        scrollArea.setPreferredSize(new Dimension(WIDTH, HEIGHT - 40));



        this.add(scrollArea, BorderLayout.CENTER);

    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Redraw the table of data.
     * @boolean loadAll When true the table data is reloaded in its entirety.
     */
    //==================================================================================================================
    public void redraw(boolean loadAll){

        directoryListing.removeAll();//Clear components.
        if(loadAll)
            recordController.loadAll();

        for(int x = 0; x < recordController.records.size();  x++){
            SongList d = new SongList(recordController.records.get(x));
            directoryListing.add(d);
        }//end x
        directoryListing.revalidate();
        this.repaint();
    }//=================================================================================================================

    //==================================================================================================================
    /**
     * Add into the north panel search facilities.
     */
    //==================================================================================================================
    public void addNorthPanel(){

        cmd_search = new JButton("Search");
        cmd_search.addActionListener(this);
        jtf_search = new JTextField(40);

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Search Songs"));
        northPanel.add(jtf_search);
        northPanel.add(cmd_search);

        this.add(northPanel,BorderLayout.NORTH);

    }//=================================================================================================================


    //==================================================================================================================
    /**
     * Adds the panel at the bottom containing the add and delete buttons.
     */
    //==================================================================================================================
    public void addSouthPanel(){
        //Add south panel
        cmd_add = new JButton("Add");
        cmd_del = new JButton("Delete");
        cmd_update = new JButton("Update");

        cmd_add.addActionListener(this);
        cmd_del.addActionListener(this);
        cmd_update.addActionListener(this);

        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel,BoxLayout.X_AXIS));
        southPanel.add(Box.createGlue());
        southPanel.add(cmd_add);
        southPanel.add(Box.createGlue());
        southPanel.add(cmd_update);
        southPanel.add(Box.createGlue());
        southPanel.add(cmd_del);
        southPanel.add(Box.createGlue());
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
        InputDialogView diag = new InputDialogView();
        diag.addListener(this);
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
        Object cmp = e.getSource();

        if(cmp == cmd_add){
            System.out.println("Add");
            openDialog();
        }
        else if(cmp == cmd_update){
            System.out.println("Update Selected");
            updateSelected();
        }
        else if (cmp == cmd_del){
            System.out.println("Del");
            delRecord();
        }
        else if(cmp == cmd_search){
            String src = jtf_search.getText();
            search(src);
        }
    }//end action performed=============================================================================================




    //==================================================================================================================
    /**
     * A simmple main method to run our program.
     * @param args Data that can be passed in from the outside.
     */
    //==================================================================================================================
    public static void main(String[] args){
        SongDirectory dir = new SongDirectory();
    }//=================================================================================================================
}//#####################################################################################################################
