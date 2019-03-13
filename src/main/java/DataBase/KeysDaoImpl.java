package DataBase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class KeysDaoImpl implements KeysDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Keys vocabulary) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(vocabulary);
        tx.commit();
        session.close();
    }
    @Override
    public List<Keys> getKeysList() {
        Session session = this.sessionFactory.openSession();
        String hql = "from Vocabulary";
        List<Keys> VocabularyList = session.createQuery(hql).list();
        session.close();
        return VocabularyList;
    }
}
