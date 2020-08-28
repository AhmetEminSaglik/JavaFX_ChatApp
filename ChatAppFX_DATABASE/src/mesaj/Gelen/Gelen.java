/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesaj.Gelen;

import Pojo.Message;
import com.gluonhq.charm.glisten.control.Avatar;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import mesaj.BIN.Cards;

public class Gelen extends Cards<Pojo.Message> {

    @FXML
    private Avatar UserImage;

    @FXML
    private Label UserName;

    @FXML
    private Circle Online;

    @FXML
    private Label Message;

    //private Pojo.Message message;  --> !!! FARKLILAR !!! 
    @FXML
    private Label Time;

    @FXML
    private Label MessageCount;

    private Pojo.Message message;

    public Gelen() { //Pojo.Message message --> kaldırıldı
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gelen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.setOnMouseClicked((event) -> {
            VBox list = (VBox) this.getParent(); // Kesinlik VBox'a eşit oluyor ve VBox alt classılarına erişebiliryoruz

            list.getChildren().forEach((t) -> {
                Gelen gelen = (Gelen) t;
                gelen.getStyleClass().clear();  // style clasını temizledik
                this.getStyleClass().add("nonSelecetion");
            });
            this.getStyleClass().clear();

            this.getStyleClass().add("Selection");
        });
        //    this.message = message;
        /*      System.out.println(message.toString());
        System.out.println(" hata  : " + message.getMesaj());
        System.out.println(" hata  : " + message.getId());*/
 /*   UserImage.setImage(new Image(new ByteArrayInputStream(message.getUsersByKimden().getImage())));
        UserName.setText(message.getUsersByKimden().getUserName());*/

    }

    @FXML
    private void initialize() {
    }

    @Override
    public Message getData() {
        return message;
    }

    @Override
    public void setData(Message t) {
        this.message = t;
        UserImage.setImage(new Image(new ByteArrayInputStream(message.getUsersByKimden().getImage())));
        UserName.setText(message.getUsersByKimden().getUserName());
        Message.setText(t.getMesaj());

    }

}
