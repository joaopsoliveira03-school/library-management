package Repository;

import Entity.Book;
import Entity.ISBN;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements IBookRepository {
    private final List<Book> books;

    public InMemoryBookRepository() {
        books = new ArrayList<>();
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public Optional<Book> findByISBN(ISBN isbn) {
        return books.stream()
                    .filter(book -> book.getIsbn().equals(isbn))
                    .findFirst();
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }
}