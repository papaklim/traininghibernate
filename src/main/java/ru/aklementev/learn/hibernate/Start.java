package ru.aklementev.learn.hibernate;

import org.hibernate.Session;
import ru.aklementev.learn.hibernate.entity.Author;
import ru.aklementev.learn.hibernate.entity.Book;

public class Start {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Author author: new AuthorHelper().getAuthorList()) {
            System.out.println(author.getName() + " " + author.getSecond_name());
        }

        for (Book book: new BookHelper().getBookList()) {
            System.out.println(book.getName());
        }

    }
}
