package DomainService;

import Entity.Book;
import Entity.ISBN;
import Factory.BookFactory;
import Repository.IBookRepository;
import ValueObject.Author;

public class BookService {
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(ISBN isbn, String title, Author author) {
        Book book = BookFactory.createBook(isbn, title, author);
        bookRepository.save(book);
        return book;
    }
}
