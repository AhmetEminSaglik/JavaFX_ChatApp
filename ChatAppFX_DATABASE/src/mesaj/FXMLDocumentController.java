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
import mesaj.BIN.Cards;
import mesaj.BIN.DatabaseManager;
import mesaj.Gelen.Gelen;
import mesaj.Messages.BizdenGiden;

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
    int ID = 5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Profil userProfil = new Profil();
        Profil_Anchor.getChildren().add(userProfil);

        DatabaseManager<Pojo.Message> message = new DatabaseManager<>();

        message.gets(Pojo.Message.class).filtered(t -> t.getUsersByKime().getId() == 5).forEach((t) -> {
            boolean add = true;
            Cards<Pojo.Message> cards = null;
            if (GelenList.getChildren().size() > 0) {
                for (int i = 0; i < GelenList.getChildren().size(); i++) //GelenList.getChildren().forEach();
                {
                    cards = (Cards) GelenList.getChildren().get(i); // İçeriden s ile aldığımız veriyi Cards'a eşitleyebildik --> SEBEBİ : Gelen classımız Cards'ı extends ettiği için
                    if (cards.getData().getUsersByKimden().getId() == t.getUsersByKimden().getId()) {
                        add = false;
                        break;
                    }
                }
            }

            if (add) { // add == true
                Gelen gelen = new Gelen();
                gelen.setData(t); // gelen message sınıfı bilgilerini setler
                GelenList.getChildren().add(gelen);
            } else {
                if (cards != null) {
                    cards.setData(t);

                }
            }
        });

        DatabaseManager<Pojo.Users> user = new DatabaseManager<>();
        //    System.out.println(ID + " Gelen kullanıcı adı --> " + user.get(ID, Pojo.Users.class).getFirstName());

        /*   for (int i = 0; i < 15; i++) {
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
        }*/
 /*     Send.setOnKeyPressed((event) -> {
            System.out.println(event.getCode());
        });*/
        MessageText.setOnKeyPressed((event) -> {
            System.out.println(event.getCode());

            if (event.getCode().equals(KeyCode.ENTER)) {

                IsendMessage();
            }
        });
        /*  DatabaseManager<Pojo.Message> message = new DatabaseManager<>();
        message.gets(Pojo.Message.class).forEach(t -> {
            GelenList.getChildren().add(new Gelen(t));
        });*/
 /* Database.Users.getUsers().forEach(e -> {

            System.out.println(e.getUserName());

        });*/
 /*new Thread(new Runnable() {
            @Override
            public void run() {
             
            }
        }).start();*/
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
