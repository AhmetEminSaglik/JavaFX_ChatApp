package mesaj;

import mesaj.Profil.Profil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import mesaj.Gelen.Gelen;
import mesaj.Messages.BizdenGiden;
import mesaj.Messages.KarsidanGelen;

/**
 *
 * @author Ahmet Emin SAĞLIK
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane Profil_Anchor;
    @FXML
    private VBox GelenList;
    @FXML
    private VBox MessageList;
    @FXML
    private TextField MessageText;
    @FXML
    private Label Send;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Profil userProfil = new Profil();
        Profil_Anchor.getChildren().add(userProfil);
        for (int i = 0; i < 15; i++) {
            Gelen gelen = new Gelen();
            GelenList.getChildren().add(gelen);

        }
        for (int i = 0; i < 4; i++) {
            KarsidanGelen gelen = new KarsidanGelen();
            gelen.setMessage("Merhaba  ben yazdım...");
            MessageList.getChildren().add(gelen);
        }
        for (int i = 0; i < 4; i++) {
            BizdenGiden giden = new BizdenGiden();
            giden.setMessage("Merhaba  Karşıdan yazdınız...");
            MessageList.getChildren().add(giden);
        }
        Send.setOnKeyPressed((event) -> {
            System.out.println(event.getCode());
        });
        MessageText.setOnKeyPressed((event) -> {
            System.out.println(event.getCode());

            if (event.getCode().equals(KeyCode.ENTER)) {

                IsendMessage();
            }
        });
    }

    @FXML
    private void SendClick(MouseEvent event) {

        IsendMessage();
    }

    private void IsendMessage() {
        BizdenGiden giden = new BizdenGiden();
        giden.setMessage(MessageText.getText());
        MessageList.getChildren().add(giden);
        MessageText.setText("");
    }

}
