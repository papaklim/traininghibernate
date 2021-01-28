package ru.aklementev.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.aklementev.learn.hibernate.entity.Author;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {
    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList() {

        //открывает сессию для манипуляции с персистентными данными
        Session session = sessionFactory.openSession();

//        session.get(Author.class, 1L);

        // объект-конструктор для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Author.class);

        // первостепенный корневой ru.aklementev.leant.hibernate.entity (в sql запросе - from)
        Root<Author> root = cq.from(Author.class);

        Query query = session.createQuery(cq);

        List <Author> authorList = query.getResultList();

        session.close();

        return authorList;
    }
}
