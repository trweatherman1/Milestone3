/**
 * @authoe A Scott
 * @version V2.0
 * Hostory:
 * V1.0 Created by Andrew on 4/4/14. - Fields firstName, lastName, number.
 * V2.0 Amended by Andrew Scott on 4/12/14 Added fields age,height and date. 
 *                               Added getter and setters for these.
 * Defines a TelRecord Object.
 */
//###########################################################################
/**
 * @author Trent Weatherman
 * @author Nick Widener
 * @author Austin Richburg
 * @author Jameson Burchette
 */
public class SongRecordModel {

    private String song;
    /**
     * song name
     */
    private String artist;
    /**
     * artist name*
     */
    private String album;
    /**
     * album name*
     */
    private String genre;/**genre name**/


    //=========================================================================

    /**
     * Mo args constructor
     */
    //=========================================================================
    public SongRecordModel() {
        this("", "", "", "");

    }//========================================================================

    //=========================================================================

    /**
     * Constructs a TelRecord with first name, last name and number.
     *
     * @param s  The first name.
     * @param ar The last name.
     * @param al The number.
     */
    //=========================================================================
    public SongRecordModel(String s, String ar, String al) {
        this(s, ar, al, "");
    }//========================================================================


    //=========================================================================

    /**
     * Constructs a TelRecord with first name, last name and number.
     *
     * @param s The song.
     * @param ar The artist.
     * @param al The album.
     * @param ge The genre
     */
    //=========================================================================
    public SongRecordModel(String s, String ar, String al, String ge) {
        song = s;
        artist = ar;
        album = al;
        genre = ge;

    }//========================================================================



    //=========================================================================

    /**
     * Produce a String representation of this object.
     */
    //=========================================================================
    public String toString() {
        return song = song + ", " + artist + ", " + album + ", " + genre;
    }//=======================================================================

    /*
    Getter and setters below. Not very interesting.
     */
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String[][] getSongInfo() {
        String[][] info = {{"Title", song},
                {"Artist", artist},
                {"Album", album},
                {"Genre", genre}};
        return info;
    }
}
