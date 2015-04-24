package lib;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

//##########################################################################
/**
 * @author Andrew Scott on 4/4/14.
 * @version 2.0
 * History:
 * V1.0 4/4/2014 Handle arraylist of records for insertion and deletion.
 * V2.0 4/12/2014 Add in BDery Database Support Methods
 */
//##########################################################################
public class Controller {

    /**The database will be embedded with the app (not on some remote server)**/
    private String framework = "embedded";

    /**The name of the JDBC Driver to use**/
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    /**The connection protocol for the DB*/
    private String protocol = "jdbc:derby:";

    /**The array list of records to store in the system.**/
    ArrayList<SongRecordModel> records;

    String dbName = "derbyDB"; /**The name of the database**/

    Connection conn = null; /**The database connection **/

    /**The singleton instance of the controller.**/
    private static Controller instance;

    //========================================================================
    /**
     * A no argument constructor for the controller.
     */
    //========================================================================
    private Controller(){
        records = new ArrayList<SongRecordModel>();


        this.createTable();

        records = selectAll(true);


    }//=======================================================================

    //========================================================================

    /**
     * Get the singleton instance of this object.
     * @return
     */
    //=========================================================================
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }//========================================================================
    //========================================================================
    /**
     * Add a record t the list and insert into the database.
     * @param r The record to be inserted.
     */
    //========================================================================
    public void addRecord(SongRecordModel r){
        records.add(r);
        this.insert(r);
    }//========================================================================

    //=========================================================================
    /**
     * Add a record to the list and insert into the database.
     * @param song
     * @param artist
     * @param album
     * @param genre
     */
    //=========================================================================
    public void addRecord(String song, String artist, String album, String genre){
        this.addRecord(new SongRecordModel(song, artist, album, genre));
    }//========================================================================

    //=========================================================================
    /**
     * Remove a record from the list and the database.
     * @param r
     */
    //=========================================================================
    public void removeRecord(SongRecordModel r){
        records.remove(r);

        this.remove(r);//remove from DB

    }//========================================================================


    //=========================================================================
    /**
     * Update the record stored in the parameter r.
     * @param r
     */
    //=========================================================================
    public void updateRecord(SongRecordModel r){
        this.update(r);
    }//========================================================================

    //=========================================================================
    /**
     * Loads the appropriate JDBC driver for this environment/framework. For
     * example, if we are in an embedded environment, we load Derby's
     * embedded Driver, <code>org.apache.derby.jdbc.EmbeddedDriver</code>.
     */
    //=========================================================================
    private void loadDriver() {
        /*
         *  The JDBC driver is loaded by loading its class.
         *  If you are using JDBC 4.0 (Java SE 6) or newer, JDBC drivers may
         *  be automatically loaded, making this code optional.
         *
         *  In an embedded environment, this will also start up the Derby
         *  engine (though not any databases), since it is not already
         *  running. In a client environment, the Derby engine is being run
         *  by the network server framework.
         *
         *  In an embedded environment, any static Derby system properties
         *  must be set before loading the driver to take effect.
         */

        //Try to connect to driver
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        }
        //Fail catches.
        catch (ClassNotFoundException cnfe) {
            System.err.println("\nUnable to load the JDBC driver " + driver);
            System.err.println("Please check your CLASSPATH.");
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println(
                    "\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println(
                    "\nNot allowed to access the JDBC driver " + driver);
            iae.printStackTrace(System.err);
        }
    }//========================================================================



    //=========================================================================
    /**
     * @return The connection or null.
     */
    //=========================================================================
    public Connection connect() {

        boolean state = false;
        loadDriver();

        try{
            // providing a user name and password is optional in the embedded
            // and derbyclient frameworks
            Properties props = new Properties(); // connection properties
            //  props.put("user", "user1");
            //  props.put("password", "user1");

            //Create connection
            conn = DriverManager.getConnection(protocol + dbName + ";create=true", props);

            System.out.println("Connected to and created database " + dbName);
            return conn;
        }
        catch(SQLException ex){
            System.out.println("Error connecting to database");
        }

        return null;
    }//=========================================================================


    //==========================================================================
    /**
     * Close the connection to the DB.
     */
    //==========================================================================
    public void closeDB(){
        if (framework.equals("embedded"))
        {
            try
            {
                // the shutdown=true attribute shuts down Derby
                DriverManager.getConnection("jdbc:derby:;shutdown=true");

                // To shut down a specific database only, but keep the
                // engine running (for example for connecting to other
                // databases), specify a database in the connection URL:
                //DriverManager.getConnection("jdbc:derby:" + dbName + ";shutdown=true");
            }
            catch (SQLException se)
            {
                if (( (se.getErrorCode() == 50000)
                        && ("XJ015".equals(se.getSQLState()) ))) {
                    // we got the expected exception
                    System.out.println("Derby shut down normally");
                    // Note that for single database shutdown, the expected
                    // SQL state is "08006", and the error code is 45000.
                } else {
                    // if the error code or SQLState is different, we have
                    // an unexpected exception (shutdown failed)
                    System.err.println("Derby did not shut down normally");
                    se.printStackTrace();
                }
            }

            conn = null;
        }
    }//==========================================================================

    //===========================================================================
    /**
     * Creates a table.
     */
    //===========================================================================
    public void createTable() {

        if (conn == null)
            connect();

        try{

            //Generate statement object to use.
            Statement s =conn.createStatement();

            //Use the create syntax to create a table.

            s.execute("CREATE TABLE dir ( "
                    + " song VARCHAR(20) NOT NULL ,"
                    + " artist VARCHAR(20) NOT NULL ,"
                    + " album VARCHAR(20) NOT NULL, "
                    + " genre VARCHAR(20) NOT NULL,");


            conn.commit();
            System.out.println("Created table location");
        }
        catch(SQLException ex){

            System.out.println("Error creating table:" + ex.getMessage());
        }
        finally{
            closeDB();
        }
    }//==========================================================================

    //==========================================================================
    /**
     * Inserts the selected record into the database if possible.
     * @param tr
     */
    //==========================================================================
    private void insert(SongRecordModel tr) {

        if (conn == null)
            connect();

        try
        {
            PreparedStatement psInsert;
            psInsert= conn.prepareStatement(  "insert into dir(song, artist, album, genre) values ( ?, ?, ?, ?)");

            psInsert.setString(1, tr.getSong());
            psInsert.setString(2, tr.getArtist());
            psInsert.setString(3, tr.getAlbum());
            psInsert.setString(4, tr.getGenre());
            
            psInsert.executeUpdate();

            conn.commit();
            System.out.println("Record inserted");

        }
        catch(SQLException ex){
            System.out.println("Error inserting: " + ex.getMessage());
        }
        finally{
            closeDB();
        }

    }//==========================================================================



    //==========================================================================
    /**
     * Inserts the selected record into the database if possible.
     * @param tr
     */
    //==========================================================================
    private void update(SongRecordModel tr) {

        if (conn == null)
            connect();

        try{
            PreparedStatement psUpdate;
            psUpdate= conn.prepareStatement(  "UPDATE dir SET song=?,  artist=?, album=?, genre=?");



            psUpdate.setString(1, tr.getSong());
            psUpdate.setString(2, tr.getArtist());
            psUpdate.setString(3, tr.getAlbum());
            psUpdate.setString(4, tr.getGenre());



            //psUpdate.setTimestamp(7, Timestamp.valueOf(tr.getDate()))  ;
            psUpdate.executeUpdate();

            conn.commit();
            System.out.println("Record updated");
        }
        catch(SQLException ex){
            System.out.println("Error updating record: " + ex.getMessage() + " ::" );
        }
        finally{
            closeDB();
        }


    }//==========================================================================

    //===========================================================================
    /**
     * Remove a record from the database.
     * @param tr
     */
    //===========================================================================
    private void remove(SongRecordModel tr){

        if (conn == null)
            connect();

        try{
            PreparedStatement psUpdate;
            psUpdate= conn.prepareStatement(  "DELETE FROM dir WHERE id = " );
            psUpdate.executeUpdate();
            conn.commit();
            System.out.println("Record removed:");
        }
        catch(SQLException ex){
            System.out.println("Error removing record:" + ex.getMessage());
        }
        finally{
            closeDB();
        }

    }//=========================================================================

    //===========================================================================
    /**
     * Remove a record from the database.
     */
    //===========================================================================
    public void dropTable(){

        if (conn == null)
            connect();

        try{
            //Generate statement object to use.
            Statement s =conn.createStatement();
            s.execute("drop table location");


            conn.commit();
            System.out.println("Record updated");
        }
        catch(SQLException ex){
            System.out.println("Error removing record.");
        }
        finally{
            closeDB();
        }

    }//=========================================================================

    //==========================================================================
    /**
     * Reload all records in the database.
     */
    //==========================================================================
    public void loadAll(){
        selectAll(true);
    }//=========================================================================

    //===========================================================================
    /**
     * Gets all the records in the database
     * @param clear If true selected records replace existing.
     * @return An ArrayList containing the items.
     */
    //===========================================================================
    private ArrayList<SongRecordModel> selectAll(boolean clear) {

        if (conn == null)
            connect();

        ResultSet rs = null;
        try{
            //Generate statement object to use.
            Statement s =conn.createStatement();
	   	
		   /*We select the rows and verify the results. */
            rs = s.executeQuery( "SELECT * FROM dir ORDER BY artist");

            if (clear) records.clear();

            while ( rs.next()){
                SongRecordModel t = new SongRecordModel(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

                records.add(t);
            }
        }
        catch(SQLException ex){
            System.out.println("Error performing selection: " + ex.getMessage());
        }
        finally{
            closeDB();
        }

        return records;
    }//=========================================================================


    //===========================================================================
    /**
     * Gets all the records in the database
     * @param
     * @param clear When true results will replace rather than be added to existing.
     * @return An ArrayList containing the items.
     */
    //===========================================================================
    private ArrayList<SongRecordModel> select(String where, boolean clear) {

        if (conn == null)
            connect();

        ResultSet rs = null;
        try{
            //Generate statement object to use.
            Statement s =conn.createStatement();
	   	
		   /*We select the rows and verify the results. */
            rs = s.executeQuery( "SELECT * FROM dir ORDER BY artist WHERE " + where);


            if (clear) records.clear();

            while ( rs.next()){
                new SongRecordModel(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        }
        catch(SQLException ex){
            System.out.println("Error performing selection.");
        }
        finally{
            closeDB();
        }

        return records;
    }//=========================================================================


    //===========================================================================
    /**
     * Gets all the records in the database
     * @param where The where The where clause.
     * @param clear When true the array list of data is cleared before being
     * populated.
     * @return An ArrayList containing the items.
     */
    //===========================================================================
    public ArrayList<SongRecordModel> selectNameAndNumber(String where, boolean clear) {


        String query = "SELECT song, artist, album FROM dir  WHERE " + where;


        System.out.println("SELECT: " + query);


        if (conn == null)
            connect();

        ResultSet rs = null;
        try{
            //Generate statement object to use.
            Statement s =conn.createStatement();
	   	
		   /*We select the rows and verify the results. */
            rs = s.executeQuery( query);

            if (clear) records.clear();

            while ( rs.next()){
                SongRecordModel t= new SongRecordModel(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(1)
                );

                this.records.add(t);
            }
            System.out.println("Selection " + where + " complete");
        }
        catch(SQLException ex){
            System.out.println("Error performing selection: " +ex.getMessage());
        }
        finally{
            closeDB();
        }

        return records;
    }//=========================================================================


}//############################################################################
