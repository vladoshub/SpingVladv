package DataBase;

import org.hibernate.SessionFactory;

public class VocabularyDaoImpl {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
