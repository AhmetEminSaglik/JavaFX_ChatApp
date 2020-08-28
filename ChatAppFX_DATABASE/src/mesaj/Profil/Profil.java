package mesaj.Profil;

import mesaj.BIN.Config;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Profil extends AnchorPane {

    public Profil() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profil.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            System.out.println("fxmlLoader : " + fxmlLoader);
            fxmlLoader.load();
        } catch (IOException exception) {
            System.out.println(">>>>> HATA  --> " + exception);

            // throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
        Config.AnchorPanelConst(this, 0.0, 0.0, 0.0, 0.0);
    }
}
