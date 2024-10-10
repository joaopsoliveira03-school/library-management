package Repository;

import Entity.Book;
import Entity.ISBN;

import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookRepository{
    @Override
    public void save(Book book) {

    }

    @Override
    public Optional<Book> findByISBN(ISBN isbn) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public void delete(Book book) {

    }
}
