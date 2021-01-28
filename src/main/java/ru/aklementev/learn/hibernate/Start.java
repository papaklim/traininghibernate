package ru.aklementev.learn.hibernate;

import org.hibernate.Session;
import ru.aklementev.learn.hibernate.entity.Author;

public class Start {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Author author: new AuthorHelper().getAuthorList()
             ) {
            System.out.println(author);
        }

    }
}
