package Factory;

import Entity.Book;
import Entity.ISBN;
import ValueObject.Author;

public class BookFactory {
    public static Book createBook(ISBN isbn, String title, Author author) {
        return new Book(isbn, title, author);
    }
}
