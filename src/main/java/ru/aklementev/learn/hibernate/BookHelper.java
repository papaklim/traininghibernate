package ru.aklementev.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.aklementev.learn.hibernate.HibernateUtil;
import ru.aklementev.learn.hibernate.entity.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {

    SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


    public List<Book> getBookList() {

        //открывает сессию для манипуляции с персистентными данными
        Session session = sessionFactory.openSession();

        // объект-конструктор для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Book.class);

        // первостепенный корневой ru.aklementev.leant.hibernate.entity (в sql запросе - from)
        Root<Book> root = cq.from(Book.class);

        Query query = session.createQuery(cq);

        List<Book> bookList = query.getResultList();

        session.close();

        return bookList;
    }
}
