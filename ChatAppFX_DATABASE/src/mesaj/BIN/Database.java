package mesaj.BIN;

import Pojo.NewHibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Database {

    private SessionFactory sessionFactory;

    public void connect() {
        sessionFactory = NewHibernateUtil.getSessionFactory();
    }

    public void disconnect() {
        sessionFactory.close();
    }

    /* kaç tane tablo varsa hepsi için class açmamız gerekecek bu yüzden bu yöntemi kullanmıyoruz
    public static class Users {

        public static ObservableList<Pojo.Users> getUsers() {

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            ObservableList<Pojo.Users> users = FXCollections.observableList(session.createSQLQuery("SELECT * FROM users").addEntity(Pojo.Users.class).list());
            transaction.commit();
            session.close();
            return users;

        }
    }*/
}
