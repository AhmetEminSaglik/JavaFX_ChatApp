/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesaj.Gelen;

import com.gluonhq.charm.glisten.control.Avatar;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 *
 * @author Ahmet Emin SAĞLIK
 */
public class Gelen extends HBox {

    @FXML
    private Avatar UserImage;

    @FXML
    private Label UserName;

    @FXML
    private Circle Online;

    @FXML
    private Label Message;

    @FXML
    private Label Time;

    @FXML
    private Label MessageCount;

    public Gelen() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gelen.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.setOnMouseClicked((event) -> { // bu objeye tıklandığında ne olsun  this -> extend edilen Hbox'u referans ediyor 
            VBox list = (VBox) this.getParent(); // Kesinlik VBox'a eşit oluyor ve VBox alt classılarına erişebiliryoruz
            // yukarıyı Object list = (Object) this.getParent();  da yapabilirdik ama obje sınıfında  getChildren yok o yüzden aşağıyız yazamaz/ hata alırız
            list.getChildren().forEach((t) -> { // for döngüsü hızlı hali
                Gelen gelen = (Gelen) t;
                gelen.getStyleClass().clear();  // style clasını temizledik
                this.getStyleClass().add("nonSelecetion");
            });
            this.getStyleClass().clear();

            this.getStyleClass().add("Selection");
        });

    }

    @FXML
    private void initialize() {
    }
}
