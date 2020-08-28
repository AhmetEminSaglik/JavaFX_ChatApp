package mesaj.BIN;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class Config {

    public static void AnchorPanelConst(Region region, double top, double left, double right, double bottom) {

        AnchorPane.setTopAnchor(region, top);
        AnchorPane.setLeftAnchor(region, left);
        AnchorPane.setRightAnchor(region, right);
        AnchorPane.setBottomAnchor(region, bottom);

    }

}
