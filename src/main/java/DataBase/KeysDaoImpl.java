package DataBase;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.util.List;
@Repository
public class KeysDaoImpl implements KeysDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public KeysDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
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
    @Override
    public List<Keys>  findByKey(String key) {
       Session session = this.sessionFactory.openSession();
       /* List ux = session.createQuery("SELECT id FROM Keys where key='"+key+"'").list();
        Words  w = findWordsById((int)ux.get(1));*/
        Criteria criteria = session.createCriteria(Keys.class);
        List<Keys> ux = criteria.add(Restrictions.eq("key", key)).list();
        Keys keys = new Keys();
  //      keys.setId(17);
  //      delete(keys);
 //       delete(ux.get(13).getWords().get(0));
        session.close();
       return ux;
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
    public void delete(Object keys) {
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
