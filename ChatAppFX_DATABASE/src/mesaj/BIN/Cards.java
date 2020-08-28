package mesaj.BIN;

import javafx.scene.layout.HBox;

public abstract class Cards<T> extends HBox {

    public abstract T getData();

    public abstract void setData(T t);

}
