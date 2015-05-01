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

    /**The database will be built into the program**/
    private String framework = "embedded";

    /**The JDBC Driver to use**/
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    /**The connection protocol for the DB*/
    private String protocol = "jdbc:derby:";

    /**The array list of records to store in the system.**/
    ArrayList<SongRecordModel> records;

    /**The name of the database in use **/
    String database = "derbyDB";

    /**setting a Connection object connection to null**/
    Connection connect = null;

    /**The singleton instance of the controller.**/
    private static Controller instance;

    //========================================================================
    /**
     * A constructor for the Controller class
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
     * @return the instance of the singleton
     */
    //=========================================================================
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }//========================================================================
    //========================================================================
    /**
     * Add a SongRecordModel record to the list and insert into the database.
     * @param record The record to be inserted.
     */
    //========================================================================
    public void addRecord(SongRecordModel record){
        records.add(record);
        this.insert(record);
    }//========================================================================

    //=========================================================================
    /**
     * A different addRecord method that puts the song, artist, album and genre
     * @param song
     * @param artist
     * @param album
     * @param genre
     */
    //=========================================================================
    public void addRecord(String song, String artist, String album, String genre){
        this.addRecord(new SongRecordModel(song, artist, album, genre));
    }


    /**
     * Remove a record from the list and the database.
     * @param record
     */
     public void removeRecord(SongRecordModel record){
        records.remove(record);

        //remove the record from the database
        this.remove(record);

    }



    /**
     * Update the record stored in the SongRecordModel record.
     * @param record
     */

    public void updateRecord(SongRecordModel record){
        this.update(record);
    }

    /**
     * Loads the JDBC driver into this method.
     */
    //=========================================================================
    private void loadDriver() {
        //A try catch block to try to load the driver
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        }
        //the catches and exceptions thrown if the driver doesn't load.
        catch (ClassNotFoundException cnfe) {
            System.err.println("Unable to load driver " + driver);
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println(
                    "Unable to instantiate driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println(
                    "Not allowed to access driver " + driver);
            iae.printStackTrace(System.err);
        }
    }


    /**
     * Connects to the database
     * @return true if connected
     * @return false if not connected
     */
    //=========================================================================
    public Connection connect() {

        boolean state = false;
        loadDriver();

        try{//try to create a connection to the database

            Properties properties = new Properties();


            //Create a connection to the database
            connect = DriverManager.getConnection(protocol + database + ";create=true", properties);

            System.out.println("Connected to and created database " + database);
            return connect;
        }//catch exception thrown
        catch(SQLException ex){
            System.out.println("Error connecting to database");
        }

        return null;
    }



    /**
     * Close the connection just made to the database.
     */

    public void closeDB(){
        if (framework.equals("embedded"))
        {
            try//try to shut down the connection to the database
            {
                DriverManager.getConnection("jdbc:derby:;shutdown=true");
            }
            //catch an exception being thrown
            catch (SQLException se)
            {
                if (( (se.getErrorCode() == 50000)
                        && ("XJ015".equals(se.getSQLState()) ))) {

                    System.out.println("Shut down");

                } else {

                    System.err.println("Error shutting downy");
                    se.printStackTrace();
                }
            }

            connect = null;
        }
    }

    /**
     * Creates the table to put records into
     */
    public void createTable() {
        /**if connect is null then call the connect method**/
        if (connect == null)
            connect();

        try{//try to connect to the table


            Statement statement = connect.createStatement();

            //Create a table using the create syntax

            statement.execute("CREATE TABLE songDirectory ( "
                    + " id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
                    + " song VARCHAR(100) NOT NULL ,"
                    + " artist VARCHAR(100) NOT NULL ,"
                    + " album VARCHAR(100) NOT NULL, "
                    + " genre VARCHAR(100) NOT NULL)");

            //commit to connect
            connect.commit();

            System.out.println("Created table location");
        }
        //catch exception thrown
        catch(SQLException ex){

            System.out.println("Could not create table: " + ex.getMessage());
        }
        //finally call the closeDB() method
        finally{
            closeDB();
        }
    }

    /**
     * Inserts the selected record into the database if possible.
     * @param record
     */

    private void insert(SongRecordModel record) {

        if (connect == null)
            connect();

        try
        {
            PreparedStatement insert;
            //inserting into the songDirectory table
            insert= connect.prepareStatement(  "insert into songDirectory(song, artist, album, genre) values ( ?, ?, ?, ?)");

            //set the string of the first position to a song
            insert.setString(1, record.getSong());

            //set the string of the second position to an artist
            insert.setString(2, record.getArtist());

            //set the string of the third position to an album
            insert.setString(3, record.getAlbum());

            //set the string of the fourth position to a genre
            insert.setString(4, record.getGenre());

            //update after insert
            insert.executeUpdate();

            connect.commit();
            System.out.println("Record inserted");

        }
        catch(SQLException ex){
            System.out.println("Record not inserted: " + ex.getMessage());
        }
        finally{
            closeDB();
        }

    }




    /**
     * Inserts a selected record into the database
     * @param record
     */

    private void update(SongRecordModel record) {

        if (connect == null)
            connect();

        try{
            PreparedStatement update;
            update = connect.prepareStatement(  "UPDATE songDirectory SET song=?,  artist=?, album=?, genre=?");


            //update the string of the first position to a song
            update.setString(1, record.getSong());

            //update the string of the second position to an artist
            update.setString(2, record.getArtist());

            //update the string of the third position to an album
            update.setString(3, record.getAlbum());

            //update the string of the fourth position to a genre
            update.setString(4, record.getGenre());

            update.executeUpdate();

            connect.commit();
            System.out.println("Record updated");
        }
        catch(SQLException ex){
            System.out.println("Song Directory did not update record: " + ex.getMessage() );
        }
        finally{
            closeDB();
        }
    }


    /**
     * Remove a record from the database.
     * @param file
     */

    private void remove(SongRecordModel file){

        if (connect == null )
            connect();

        try{
            PreparedStatement update;
            update = connect.prepareStatement(  "DELETE FROM songDirectory WHERE song = \'Love Somebody\'" );
            update.executeUpdate();
            connect.commit();
            System.out.println("Record removed:");
        }
        catch(SQLException ex){
            System.out.println("Problem removing record:" + ex.getMessage());
        }
        finally{
            closeDB();
        }

    }


    /**
     * Start the table completely over
     */

    public void dropTable(){

        if (connect == null)
            connect();

        try{

            Statement statement = connect.createStatement();
            statement.execute("drop table location");


            connect.commit();
            System.out.println("Record updated");
        }
        catch(SQLException ex){
            System.out.println("Error removing record.");
        }
        finally{
            closeDB();
        }
    }

    /**
     * Load all the records into the table
     */

    public void loadAll(){
        selectAll(true);
    }


    /**
     * Get all the records in the database
     * @param clear if clear() clear all the records
     * @return An ArrayList that holds SongRecordModel items
     */

    private ArrayList<SongRecordModel> selectAll(boolean clear) {

        if (connect == null)
            connect();

        ResultSet rs = null;
        try{

            Statement statement =connect.createStatement();
	   	

            rs = statement.executeQuery( "SELECT * FROM songDirectory ORDER BY song");

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
    }



    /**
     * Gets all the records in the database
     * @param
     * @param clear When true results will replace rather than be added to existing.
     * @return An ArrayList containing the items.
     */

    private ArrayList<SongRecordModel> select(String where, boolean clear) {

        if (connect == null)
            connect();

        ResultSet rs = null;
        try{

            Statement s =connect.createStatement();
	   	

            rs = s.executeQuery( "SELECT * FROM songDirectory ORDER BY artist WHERE " + where);


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


        String query = "SELECT song, artist, album FROM songDirectory  WHERE " + where;


        System.out.println("SELECT: " + query);


        if (connect == null)
            connect();

        ResultSet rs = null;
        try{

            Statement statement =connect.createStatement();
	   	

            rs = statement.executeQuery( query);

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
    }
}
