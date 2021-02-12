package ru.aklementev.learn.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import ru.aklementev.learn.hibernate.entity.Author;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class);

    private SessionFactory sessionFactory;


    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList() {

        //открывает сессию для манипуляции с персистентными данными
        Session session = sessionFactory.openSession();

        // объект-конструктор для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Author.class);

        // первостепенный корневой ru.aklementev.leant.hibernate.entity (в sql запросе - from)
        Root<Author> root = cq.from(Author.class);

        Query query = session.createQuery(cq);

        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }

    public Author addAuthor(Author author) {

        List<Author> currentList = getAuthorList();
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            boolean wasFound = false;
            for (Author a : currentList) {
                if (a.equals(author)) {
                    wasFound = true;
                    LOG.warn("Такой автор уже есть");
                }
            }
            if (!wasFound)
                session.save(author);
        } catch (HibernateException e) {
            if (session != null)
            session.getTransaction().rollback();
            LOG.trace(e.getMessage());
        } finally {
            if (session!=null)
            session.close();

        }
        return author;
    }
}
