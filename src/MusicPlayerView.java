import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Created by Jameson on 4/28/2015.
 */
public class MusicPlayerView extends BorderPane {
    SongRecordModel songRecordModel;
    Font font;

    public MusicPlayerView() {
        font = new Font(18);
        setPadding(new Insets(0, 0, 0, 45));
    }

    private HBox songInfo() {
        String[][] songInfo = songRecordModel.getSongInfo();
        VBox fields = new VBox(40);
        VBox values = new VBox(40);
        fields.setAlignment(Pos.CENTER_LEFT);
        values.setAlignment(Pos.CENTER_LEFT);
        for (String[] fieldInfo : songInfo) {
            Label field = new Label(fieldInfo[0] + ":");
            field.setFont(font);
            fields.getChildren().add(field);
            Label value = new Label(fieldInfo[1]);
            value.setFont(font);
            values.getChildren().add(value);
        }
        HBox songInfoBox = new HBox(10);
        songInfoBox.setAlignment(Pos.CENTER);
        songInfoBox.getChildren().addAll(fields, values);
        return songInfoBox;
    }

    private ImageView image () {
        try {
            String imageLocation = songRecordModel.getAlbum() + ".jpg";
            ImageView img = new ImageView(imageLocation);
            img.setPreserveRatio(true);
            return img;
        } catch (Exception e) {
            ImageView img = new ImageView(this.getClass().getResource("JukeboxNotes.png").toString());
            img.setPreserveRatio(true);
            img.setFitHeight(300);
            return img;
        }
    }

    public void setSong(SongRecordModel song) {
        songRecordModel = song;
        ImageView img = image();
        setLeft(img);
        setAlignment(img, Pos.CENTER);
        setCenter(songInfo());
    }

    public Scene makeScene() {
        ImageView img = new ImageView(this.getClass().getResource("Background.png").toString());
        StackPane stack = new StackPane();
        stack.getChildren().add(img);
        stack.getChildren().add(this);
        Scene scene = new Scene(stack, 900, 600);
        return scene;
    }
}