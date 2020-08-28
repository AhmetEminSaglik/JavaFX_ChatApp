package mesaj.BIN;

import Pojo.NewHibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DatabaseManager<T> implements IDatabase<T> {

    @Override
    public T get(int ID, Class s) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T t = (T) session.get(s, ID);
        transaction.commit();
        session.flush();
        //   session.close();
        return t;
    }

    @Override
    public ObservableList<T> gets(Class s) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ObservableList<T> list = FXCollections.observableList(session.createCriteria(s).list());
        transaction.commit();
        session.flush();
        //  session.close();
        return list;
    }

    @Override
    public void update(Object t) {
    }

    @Override
    public void delete(Object t) {
    }

    @Override
    public void save(Object t) {
    }

    @Override
    public void saveorupdate(Object t) {
    }

}
