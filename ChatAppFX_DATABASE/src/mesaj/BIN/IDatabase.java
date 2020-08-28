package mesaj.BIN;

import javafx.collections.ObservableList;

public interface IDatabase<T> {
    public  T get(int ID,Class s);
    public ObservableList<T> gets(Class s);
    public void update(T t);
    public void delete(T t);   
    public void save(T t);
    public void saveorupdate(T t);
    

}
