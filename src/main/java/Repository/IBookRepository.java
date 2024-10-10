package Repository;

import Entity.Book;
import Entity.ISBN;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    void save(Book book);
    Optional<Book> findByISBN(ISBN isbn);
    List<Book> findAll();
    void delete(Book book);
}