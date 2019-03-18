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
        try {
            Transaction tx = session.beginTransaction();
            session.persist(vocabulary);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public Keys findById(int id) {
        Session session = this.sessionFactory.openSession();
        return (Keys) session.getSessionFactory().openSession().get(Keys.class, id);
    }
    @Override
    public void update(Keys keys) {
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(keys);
        tx1.commit();
        session.close();
    }
    @Override
    public void delete(Keys keys) {
        Session session = this.sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(keys);
        tx1.commit();
        session.close();
    }
    @Override
    public Words findWordsById(int id) {
        return (Words) this.sessionFactory.openSession().get(Words.class, id);
    }

    @Override
    public List<Keys> getKeysList() {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Keys";
        List<Keys> VocabularyList = session.createQuery(hql).list();
        session.close();
        return VocabularyList;

    }
}
