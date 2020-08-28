package mesaj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mesaj.BIN.Database;

public class mesaj extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       // Database.connect();
       Database database = new Database();
       database.connect();

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest((event) -> {
            database.disconnect();
        });

        /*stage.setOnCloseRequest((event) -> {  --> !!!!!!!! ÖNEMLİ
            JOptionPane.showMessageDialog(null, "Kapatma request");
        });*/
    }
 
}
