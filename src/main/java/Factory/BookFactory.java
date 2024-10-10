package Factory;

import Entity.Book;
import Entity.ISBN;
import ValueObject.Author;

public class BookFactory {
    public static Book createBook(String title, Author author) {
        return new Book(ISBNFactory.createISBN(), title, author);
    }
}
