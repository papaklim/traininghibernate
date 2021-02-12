package ru.aklementev.learn.hibernate;

import org.jboss.logging.Logger;
import ru.aklementev.learn.hibernate.entity.Author;
import ru.aklementev.learn.hibernate.entity.Book;

public class Start {

    private static final Logger LOG = Logger.getLogger(Start.class);

    public static void main(String[] args) {


        for (Author author : new AuthorHelper().getAuthorList()) {
            LOG.info(author.getName() + " " + author.getSecondName());
        }

        for (Book book : new BookHelper().getBookList()) {
            LOG.info(book.getName());

        }

        Author newAuthor = new Author("Александр", "Блок");
        Author existingAuthor = new Author("Александр", "Пушкин");
        Author anotherAuthor = new Author("Николай", "Гоголь");

        new AuthorHelper().addAuthor(existingAuthor);
        new AuthorHelper().addAuthor(newAuthor);
        new AuthorHelper().addAuthor(anotherAuthor
        );


    }
}
