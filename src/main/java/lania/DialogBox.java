package lania;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import java.io.IOException;

//@@author nguyiyang-reused
//Reused from https://se-education.org/guides/tutorials/javaFx.html
// with minor modifications
public class DialogBox extends HBox {

    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(img);
    }

    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    public static DialogBox getUserDialog(String l, Image image) {
        DialogBox userDialogBox = new DialogBox(l, image);
        userDialogBox.setDialogBoxBackgroundColor("#ff9191");
        return userDialogBox;
    }

    public static DialogBox getLaniaDialog(String l, Image image) {
        DialogBox laniaDialogBox = new DialogBox(l, image);
        laniaDialogBox.flip();
        laniaDialogBox.setDialogBoxBackgroundColor("#ffe591");
        return laniaDialogBox;
    }

    private void setDialogBoxBackgroundColor(String hexValue) {
        this.setBackground(new Background(new BackgroundFill(Paint.valueOf(hexValue), null, null)));
    }
}
//@@author
