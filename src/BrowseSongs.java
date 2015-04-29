import javax.swing.*;
import java.awt.*;

/**
 * Created by Trent on 4/22/2015.
 */
public class BrowseSongs {

    String[] columnNames = {"Song", "Artist", "Album", "Genre"};
    /*
    Object[][] data = {
            {"Dayum Baby Dayum", "Florida Georgia Line", "This is How We Roll", "Country"},
            {"Downfall of us All", "A Day To Remember", "Homesick", "Punk"},
            {"Drunk On You", "Luke Bryan", "TailGates & TanLines", "Country"},
            {"In The Air Tonight", "Phil Collins", "Unknown", "Alternative"}


    };
    */

    JTable table = new JTable();
    JScrollPane browse;

    public BrowseSongs(){
        browse = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(table.getTableHeader(), BorderLayout.NORTH);
        container.add(table, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        BrowseSongs brow = new BrowseSongs();
    }
}
