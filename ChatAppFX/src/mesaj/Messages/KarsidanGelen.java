/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesaj.Messages;

import com.gluonhq.charm.glisten.control.Avatar;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Ahmet Emin SAĞLIK
 */
public class KarsidanGelen extends HBox {

    @FXML
    private Label Time;

    @FXML
    private ImageView Check;

    @FXML
    private Label Message;

    @FXML
    private Avatar UserImage;

    public KarsidanGelen() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KarsidanGelen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
    }

    public String getTime() {
        return Time.getText();
    }

    public void setTime(String Time) {
        this.Time.setText(Time);
    }

    public ImageView getCheck() {
        return Check;
    }

    public void setCheck(ImageView Check) {
        this.Check = Check;
    }

    public String getMessage() {
        return Message.getText();
    }

    public void setMessage(String Message) {
        this.Message.setText(Message);
    }

    public Avatar getUserImage() {
        return UserImage;
    }

    public void setUserImage(Avatar UserImage) {
        this.UserImage = UserImage;
    }

}
